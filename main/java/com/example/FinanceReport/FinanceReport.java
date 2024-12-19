package com.example.FinanceReport;

import com.example.Payment.Payment;
import java.util.ArrayList;
import java.util.List;


public class FinanceReport {

    private final List<Payment> payments;
    private String creatorFio;
    private Integer createDay, createMonth, createYear;

    
    //Конструктор класса FinanceReport.
     
    public FinanceReport(String creatorFio, Integer createDay, Integer createMonth, Integer createYear) {
        this.creatorFio = creatorFio;
        this.createDay = createDay;
        this.createMonth = createMonth;
        this.createYear = createYear;
        this.payments = new ArrayList<>();
    }

    public FinanceReport(FinanceReport financeReport) {
        this.creatorFio = financeReport.creatorFio;
        this.createDay = financeReport.createDay;
        this.createMonth = financeReport.createMonth;
        this.createYear = financeReport.createYear;
        this.payments = new ArrayList<>(financeReport.payments);
    }

    public FinanceReport() {
        this.payments = new ArrayList<>();
    }

    //Геттеры
    public String getCreatorFio() {
        return creatorFio;
    }

    public Integer getCreateDay() {
        return createDay;
    }

    public Integer getCreateMonth() {
        return createMonth;
    }

    public Integer getCreateYear() {
        return createYear;
    }

    public Payment getPayment(int index) {
        return payments.get(index);
    }
    
    public List<Payment> getPaymentsList() {
        return payments;
    }

    public Integer getPaymentsArraySize() {
        return payments.size();
    }
    
    
    //Сеттеры
    public void setCreatorFio(String creatorFio) {
        this.creatorFio = creatorFio;
    }
    
    public void setCreateDay(Integer createDay) {
        this.createDay = createDay;
    }

    public void setCreateMonth(Integer createMonth) {
        this.createMonth = createMonth;
    }

    public void setCreateYear(Integer createYear) {
        this.createYear = createYear;
    }

    public Payment setPayment(int index, Payment payment) {
        return payments.set(index, payment);
    }


//---------------------------------------------------------------------------------------
    
    public void add(Payment payment) {
        this.payments.add(payment);
    }

    
    //Добавляет платеж в список платежей, создавая новый объект Payment.
    
    public void add(String fio,Integer day, Integer month, Integer year, Float summa) {
        this.payments.add(new Payment(fio,day,month,year,summa));
    }

    
    public String allPaymentsToString() {
        StringBuilder finalText = new StringBuilder();
        for (Payment payment : payments) {
            finalText.append("\n").append(payment.toString());
        }
        return finalText.toString();
    }

    
    public String allCopedPaymentsToString() {
        StringBuilder finalText = new StringBuilder();
        for (Payment payment : payments) {
            finalText.append("\n").append(payment.toString());
        }
        return finalText.toString();
    }

    
    @Override
    public String toString() {
        return String.format("Автор: %s, дата: %s.%s.%s%s", getCreatorFio(), getCreateDay(), getCreateMonth(), getCreateYear(), allPaymentsToString());
    }
}
