# 💙 Certidão de Namoro PDF

API REST desenvolvida em **Java com Spring Boot** para geração automática de certidões de namoro personalizadas em formato PDF.

O sistema recebe os dados de um casal através de uma requisição HTTP e gera um documento PDF utilizando **Apache PDFBox**, permitindo personalização de informações, textos e elementos visuais.

Projeto desenvolvido com foco em prática de:

* Desenvolvimento de APIs REST
* Manipulação e geração de arquivos PDF
* Organização em camadas no Spring Boot
* Processamento de dados via JSON

## 🚀 Tecnologias

* Java
* Spring Boot
* Spring Web
* Apache PDFBox
* Maven

## 📌 Endpoint

### Gerar certidão

**POST**

```
http://localhost:8080/api/cliente
```

### JSON de exemplo

```json
{
    "nome1": "joão",
    "nome2": "Maria",
    "dataInicio": "20/06/2026",
    "termos": "Declaração de União Afetiva",
    "termos2": "Comprovação de Relacionamento Amoroso",
    "termos3": "Relacionamento baseado em respeito, companheirismo e reciprocidade",
    "termos4": "Livre manifestação de vontade das partes"
}
```
<img width="757" height="350" alt="image" src="https://github.com/user-attachments/assets/8570790e-a158-4680-90c8-d213bd5ac4d2" />

## 📄 Resultado

Após o envio dos dados, a API gera uma certidão personalizada em PDF utilizando Apache PDFBox.
<img width="562" height="252" alt="image" src="https://github.com/user-attachments/assets/de371456-4396-4b11-9dda-0aa0b82b849b" />


