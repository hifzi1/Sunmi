object PDFHelper {
    fun saveToPDF(context: Context, text: String) {
        val dir = File(context.getExternalFilesDir(null), "SunmiInvoices")
        if (!dir.exists()) dir.mkdirs()
        val fileName = "invoice_${System.currentTimeMillis()}.pdf"
        val file = File(dir, fileName)

        val writer = PdfWriter(file)
        val pdfDoc = PdfDocument(writer)
        val document = Document(pdfDoc)
        document.add(Paragraph(text))
        document.close()
    }
}