package service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Service;

import model.Cliente;

@Service
public class ClienteService {

    public void gerarPdf(Cliente cliente) {
        String fileName = "documento_" + cliente.getNumeroDoc() + ".pdf";

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            
            InputStream in = getClass().getResourceAsStream("/static/imagem_fundo.png");
            if (in == null) {
                throw new RuntimeException("Imagem não encontrada!");
            }
            byte[] imageBytes = in.readAllBytes();
            PDImageXObject image = PDImageXObject.createFromByteArray(document, imageBytes, "imagem_fundo.png");

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.drawImage(image, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());

                
                PDType1Font fontTitle = PDType1Font.TIMES_BOLD;
                PDType1Font fontText = PDType1Font.HELVETICA_OBLIQUE;
                PDType1Font fontText1 = PDType1Font.TIMES_ITALIC;
                int titleSize = 26;
                int textAss = 10;
                int textTerm= 11;
                int textDecla = 13;
                int textSize = 18;

                float pageWidth = page.getMediaBox().getWidth();

                String titulo = "Certidão de Namoro";
                float titleWidth = fontTitle.getStringWidth(titulo) / 1000 * titleSize;
                float titleX = (pageWidth - titleWidth) / 2;

                contentStream.beginText();
                contentStream.setFont(fontTitle, titleSize);
                contentStream.newLineAtOffset(titleX, 720);
                contentStream.showText(titulo);
                contentStream.endText();

                
                contentStream.beginText();
                contentStream.setFont(fontText, textAss);
                contentStream.newLineAtOffset(250, 680);
                contentStream.showText("Documento Nº: " + cliente.getNumeroDoc());
                contentStream.endText();

                String nome1 = "Nome: " + cliente.getNome1();
                float nome1Width = fontText.getStringWidth(nome1) / 1000 * textSize;
                float nome1X = (pageWidth - nome1Width) / 2;

                contentStream.beginText();
                contentStream.setFont(fontText, textSize);
                contentStream.newLineAtOffset(nome1X, 640);
                contentStream.showText(nome1);
                contentStream.endText();

                String nome2 = "Nome: " + cliente.getNome2();
                float nome2Width = fontText.getStringWidth(nome2) / 1000 * textSize;
                float nome2X = (pageWidth - nome2Width) / 2;

                contentStream.beginText();
                contentStream.setFont(fontText, textSize);
                contentStream.newLineAtOffset(nome2X, 610);
                contentStream.showText(nome2);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(fontText1, textSize);
                contentStream.newLineAtOffset(50, 510);
                contentStream.showText("Data de Início: " + cliente.getDataInicio());
                contentStream.endText();
                
                String subTituloTermos = "Termos do Namoro:";
                contentStream.beginText();
                contentStream.setFont(fontTitle, textSize);
                contentStream.newLineAtOffset(90, 450);
                contentStream.showText(subTituloTermos);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(fontText1, textTerm);
                contentStream.newLineAtOffset(100, 420);
                contentStream.showText("1 - " + cliente.getTermos());
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(fontText1, textTerm);
                contentStream.newLineAtOffset(100, 390);
                contentStream.showText("2 - " + cliente.getTermos2());
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(fontText1, textTerm);
                contentStream.newLineAtOffset(100, 360);
                contentStream.showText("3 - " + cliente.getTermos3());
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(fontText1, textTerm);
                contentStream.newLineAtOffset(100, 330);
                contentStream.showText("4 - " + cliente.getTermos4());
                contentStream.endText();

                String declaracao = "Declaramos, por meio deste documento simbólico, o compromisso mútuo de cultivar ";
                contentStream.beginText();
                contentStream.setFont(fontText1, textDecla);
                contentStream.newLineAtOffset(100, 230);
                contentStream.showText(declaracao);
                contentStream.endText();

                String declaracao2 = "diariamente o amor que nos une. Que esta certidão seja testemunha do nosso carinho,";
                contentStream.beginText();
                contentStream.setFont(fontText1, textDecla);
                contentStream.newLineAtOffset(95, 210);
                contentStream.showText(declaracao2);
                contentStream.endText();

                String declaracao3 = "parceria e desejo sincero de construir momentos inesquecíveis lado a lado.";
                contentStream.beginText();
                contentStream.setFont(fontText1, textDecla);
                contentStream.newLineAtOffset(120, 190);
                contentStream.showText(declaracao3);
                contentStream.endText();


                String assing = "____________________";
                contentStream.beginText();
                contentStream.setFont(fontText, textSize);
                contentStream.newLineAtOffset(50, 94);
                contentStream.showText(assing);
                contentStream.endText();


                contentStream.beginText();
                contentStream.setFont(fontText, textAss);
                contentStream.newLineAtOffset(75, 80);
                contentStream.showText(cliente.getNome1());
                contentStream.endText();


                String assTwo = "____________________";

                contentStream.beginText();
                contentStream.setFont(fontText, textSize);
                contentStream.newLineAtOffset(350, 94);
                contentStream.showText(assTwo);
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(fontText, textAss);
                contentStream.newLineAtOffset(390, 80);
                contentStream.showText(cliente.getNome2());
                contentStream.endText();

                String lei = "Lembre-se: o verdadeiro valor deste documento reside no sentimento que ele representa, sem implicações legais ou oficiais.";

                contentStream.beginText();
                contentStream.setFont(fontText, textAss);
                contentStream.newLineAtOffset(20, 20);
                contentStream.showText(lei);
                contentStream.endText();
            }

            document.save(fileName);
            System.out.println("PDF criado em: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
