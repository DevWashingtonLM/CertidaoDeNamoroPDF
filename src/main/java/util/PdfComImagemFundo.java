package util;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfComImagemFundo {

    public void gerarPdfComFundo() throws IOException {
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            InputStream in = getClass().getResourceAsStream("/static/imagem_fundo.png");
            if (in == null) {
                throw new IOException("Imagem de fundo não encontrada! Verifique o caminho.");
            }
            byte[] bytes = in.readAllBytes();

            PDImageXObject image = PDImageXObject.createFromByteArray(doc, bytes, "imagem_fundo.png");

            try (PDPageContentStream contentStream = new PDPageContentStream(doc, page)) {
                contentStream.drawImage(image, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
                contentStream.newLineAtOffset(50, 700);
                contentStream.showText("Texto por cima da imagem de fundo");
                contentStream.endText();
            }

            doc.save("pdf_com_imagem_fundo.pdf");
        }
    }
}
