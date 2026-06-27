package com.stazioneposta.reset1.ui

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.stazioneposta.reset1.R
import com.stazioneposta.reset1.utils.ReportGenerator
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ReportsActivity : AppCompatActivity() {

    private lateinit var reportTypeGroup: RadioGroup
    private lateinit var generateButton: Button
    private lateinit var backButton: Button
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        reportTypeGroup = findViewById(R.id.reportTypeGroup)
        generateButton = findViewById(R.id.generateButton)
        backButton = findViewById(R.id.backButton)

        generateButton.setOnClickListener {
            val selectedId = reportTypeGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Seleziona un tipo di report", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val reportType = when (selectedId) {
                R.id.radioDailyPdf -> "daily_pdf"
                R.id.radioDailyExcel -> "daily_excel"
                R.id.radioWeeklyPdf -> "weekly_pdf"
                R.id.radioWeeklyExcel -> "weekly_excel"
                R.id.radioMonthlyPdf -> "monthly_pdf"
                R.id.radioMonthlyExcel -> "monthly_excel"
                else -> return@setOnClickListener
            }

            generateReport(reportType)
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun generateReport(reportType: String) {
        lifecycleScope.launch {
            try {
                val reportGenerator = ReportGenerator(this@ReportsActivity)
                when (reportType) {
                    "daily_pdf" -> reportGenerator.generateDailyReportPdf()
                    "daily_excel" -> reportGenerator.generateDailyReportExcel()
                    "weekly_pdf" -> reportGenerator.generateWeeklyReportPdf()
                    "weekly_excel" -> reportGenerator.generateWeeklyReportExcel()
                    "monthly_pdf" -> reportGenerator.generateMonthlyReportPdf()
                    "monthly_excel" -> reportGenerator.generateMonthlyReportExcel()
                }
                Toast.makeText(this@ReportsActivity, "Report generato con successo", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this@ReportsActivity, "Errore nella generazione: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
