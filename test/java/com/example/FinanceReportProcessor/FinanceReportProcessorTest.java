import com.example.FinanceReport.FinanceReport;
import com.example.FinanceReportProcessor.FinanceReportProcessor;
import com.example.Payment.Payment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportProcessorTest {

    @Test
    void getPaymentsWithChar() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("Барташ Артём Владимирович", 100f, 1, 1, 2024));
        payments.add(new Payment("Батеха Алексей Владимирович", 200f, 2, 2, 2024));
        payments.add(new Payment("Судейкин Евгений Юрьевич", 300f, 3, 3, 2024));

        FinanceReport report = FinanceReportProcessor.getPaymentsWithChar(payments, 'P');
        assertEquals(1, report.getPayments().size());
        assertEquals("Petrov Petr", report.getPayments().get(0).getFio());


        report = FinanceReportProcessor.getPaymentsWithChar(payments, 'I');
        assertEquals(1, report.getPayments().size());
        assertEquals("Ivanov Ivan", report.getPayments().get(0).getFio());

        report = FinanceReportProcessor.getPaymentsWithChar(payments, 'A');
        assertEquals(0, report.getPayments().size());
    }

    @Test
    void getPaymentsLowerSumma() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("Барташ Артём Владимирович", 100f, 1, 1, 2024));
        payments.add(new Payment("Батеха Алексей Владимирович", 200f, 2, 2, 2024));
        payments.add(new Payment("Судейкин Евгений Юрьевич", 300f, 3, 3, 2024));

        FinanceReport report = FinanceReportProcessor.getPaymentsLowerSumma(payments, 250f);
        assertEquals(2, report.getPayments().size());

        report = FinanceReportProcessor.getPaymentsLowerSumma(payments, 100f);
        assertEquals(0, report.getPayments().size());

        report = FinanceReportProcessor.getPaymentsLowerSumma(payments, 350f);
        assertEquals(3, report.getPayments().size());
    }

    @Test
    void getSumPaymentOnDate() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("Барташ Артём Владимирович",100f, 1, 1, 2024));
        payments.add(new Payment("Батеха Алексей Владимиров", 200f, 1, 1, 2024));
        payments.add(new Payment("Судейкин Евгений Юрьевич", 300f, 2, 1, 2024));

        float sum = FinanceReportProcessor.getSumPaymentOnDate(payments, 1, 1, 2024);
        assertEquals(300f, sum);

        sum = FinanceReportProcessor.getSumPaymentOnDate(payments, 2, 1, 2024);
        assertEquals(300f, sum);

        sum = FinanceReportProcessor.getSumPaymentOnDate(payments, 1, 2, 2024);
        assertEquals(0f, sum);
    }

    @Test
    void getUnMonthPayment() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment("Барташ Артём Владимирович",100f, 1, 1, 2024));
        payments.add(new Payment("Батеха Алексей Владимиров",200f, 2, 2, 2024));
        payments.add(new Payment("Судейкин Евгений Юрьевич", 300f, 12, 12, 2024));

        HashMap<Integer, String> unMonthPayments = FinanceReportProcessor.getUnMonthPayment(payments, 2024);
        assertEquals(10, unMonthPayments.size());
        assertFalse(unMonthPayments.containsKey(1));
        assertFalse(unMonthPayments.containsKey(2));
        assertFalse(unMonthPayments.containsKey(12));


        unMonthPayments = FinanceReportProcessor.getUnMonthPayment(payments, 2023); //No payments in 2023
        assertEquals(12, unMonthPayments.size());
    }
}
