object ReceiptGenerator {
    fun generate(products: List<Product>): String {
        val sb = StringBuilder()
        sb.appendLine("سمات للحاسب الآلي")
        sb.appendLine("أبها - المملكة العربية السعودية")
        sb.appendLine("-------------------------")
        var total = 0.0
        for (p in products) {
            sb.appendLine("${p.name}  ${p.price} ريال")
            total += p.price
        }
        sb.appendLine("-------------------------")
        sb.appendLine("الإجمالي: $total ريال")
        sb.appendLine("${getDateTime()}")
        sb.appendLine("شكراً لتعاملكم معنا 🤝")
        return sb.toString()
    }

    private fun getDateTime(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        return sdf.format(Date())
    }
}