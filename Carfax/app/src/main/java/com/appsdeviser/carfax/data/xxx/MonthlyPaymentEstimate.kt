package com.appsdeviser.carfax.data.xxx

data class MonthlyPaymentEstimate(
    val downPaymentAmount: Double,
    val downPaymentPercent: Double,
    val interestRate: Double,
    val loanAmount: Double,
    val monthlyPayment: Double,
    val price: Double,
    val termInMonths: Int
)