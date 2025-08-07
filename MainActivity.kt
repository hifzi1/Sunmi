class MainActivity : AppCompatActivity() {
    private lateinit var productList: MutableList<Product>
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SunmiPrintHelper.getInstance().initSunmiPrinterService(this)

        productList = mutableListOf(
            Product("بيبسي", 3.0),
            Product("ماء", 2.0)
        )

        adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter

        btnPrint.setOnClickListener {
            val receipt = ReceiptGenerator.generate(productList)
            SunmiPrintHelper.getInstance().printText(receipt)
            SunmiPrintHelper.getInstance().lineWrap(3)
            PDFHelper.saveToPDF(this, receipt)
        }

        btnWhatsApp.setOnClickListener {
            val text = ReceiptGenerator.generate(productList)
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
                `package` = "com.whatsapp"
            }
            startActivity(intent)
        }
    }
}