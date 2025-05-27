package controller;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService pdfService;

    @PostMapping("/cliente")
    public ResponseEntity<String> criarCliente(@RequestBody Cliente cliente) {
        pdfService.gerarPdf(cliente);
        return ResponseEntity.ok("PDF gerado com Apache PDFBox com sucesso!");
    }
}
