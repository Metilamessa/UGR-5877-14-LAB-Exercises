class MainActivity : AppCompatActivity() {

    private lateinit var textViewCount: TextView
    private lateinit var buttonIncrement: Button
    private lateinit var buttonDecrement: Button
    private lateinit var buttonReset: Button
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCount = findViewById(R.id.textView_count)
        buttonIncrement = findViewById(R.id.button_increment)
        buttonDecrement = findViewById(R.id.button_decrement)
        buttonReset = findViewById(R.id.button_reset)

        buttonIncrement.setOnClickListener {
            count++
            updateCountText()
        }

        buttonDecrement.setOnClickListener {
            count--
            updateCountText()
        }

        buttonReset.setOnClickListener {
            count = 0
            updateCountText()
        }
    }

    private fun updateCountText() {
        textViewCount.text = count.toString()
    }
}