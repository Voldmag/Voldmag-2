import com.example.FinanceReport.FinanceReport;
import com.example.Payment.Payment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportTest {

    @Test
    void constructor_withParams() {
        FinanceReport report = new FinanceReport("Пупкин Александр Олегович", 1, 1, 2024);
        assertEquals("Пупкин Александр Олегович", report.getCreatorFio());
        assertEquals(1, report.getCreateDay());
        assertEquals(1, report.getCreateMonth());
        assertEquals(2024, report.getCreateYear());
        assertEquals(0, report.getPaymentsArraySize());
    }

    @Test
    void constructor_copy() {
        FinanceReport original = new FinanceReport("Непупкин Александр Олегович", 10, 10, 2023);
        original.add("test1",1,1,2024,100f);
        FinanceReport copy = new FinanceReport(original);

        assertEquals(original.getCreatorFio(), copy.getCreatorFio());
        assertEquals(original.getCreateDay(), copy.getCreateDay());
        assertEquals(original.getCreateMonth(), copy.getCreateMonth());
        assertEquals(original.getCreateYear(), copy.getCreateYear());
        assertEquals(original.getPaymentsArraySize(), copy.getPaymentsArraySize());
        assertEquals(original.getPayment(0).getSumma(),copy.getPayment(0).getSumma());

    }

    @Test
    void constructor_empty() {
        FinanceReport report = new FinanceReport();
        assertEquals(0, report.getPaymentsArraySize());
        assertNull(report.getCreatorFio()); 
        assertNull(report.getCreateDay());
        assertNull(report.getCreateMonth());
        assertNull(report.getCreateYear());
    }

    @Test
    void gettersAndSetters() {
        FinanceReport report = new FinanceReport();
        report.setCreatorFio("Луткин Александр Олегович");
        report.setCreateDay(15);
        report.setCreateMonth(12);
        report.setCreateYear(2023);

        assertEquals("Луткин Александр Олегович", report.getCreatorFio());
        assertEquals(15, report.getCreateDay());
        assertEquals(12, report.getCreateMonth());
        assertEquals(2023, report.getCreateYear());
    }

    @Test
    void addPayment() {
        FinanceReport report = new FinanceReport();
        Payment payment = new Payment("Пупкин Александр Олегович", 1, 1, 2024, 100f);
        report.add(payment);
        assertEquals(1, report.getPaymentsArraySize());
        assertEquals(payment, report.getPayment(0));
    }


    @Test
    void addPayment_withParams() {
        FinanceReport report = new FinanceReport();
        report.add("Пупкин Александр Олегович", 10, 10, 2023, 200f);
        assertEquals(1, report.getPaymentsArraySize());
        assertEquals("Пупкин Александр Олегович", report.getPayment(0).getFio());
        assertEquals(200f, report.getPayment(0).getSumma());
    }

    @Test
    void setPayment() {
      FinanceReport report = new FinanceReport();
      report.add("Пупкин Александр Олегович 1",10,10,2023,100f);
      Payment newPayment = new Payment("Пупкин Александр Олегович 2",11,11,2023,200f);
      report.setPayment(0,newPayment);
      assertEquals(newPayment, report.getPayment(0));
    }

    @Test
    void allPaymentsToString() {
        FinanceReport report = new FinanceReport();
        report.add("Пупкин Александр Олегович 3", 1, 1, 2024, 100f);
        report.add("Пупкин Александр Олегович 4", 2, 2, 2024, 200f);
        String expected = "\nФИО: Пупкин Александр Олегович 3, дата: 1.1.2024, сумма: 100.0\nФИО: Пупкин Александр Олегович 4, дата: 2.2.2024, сумма: 200.0";
        assertEquals(expected, report.allPaymentsToString());
    }

    @Test
    void toStringTest(){
        FinanceReport report = new FinanceReport("Test User", 1, 1, 2024);
        report.add("Пупкин Александр Олегович 3", 1, 1, 2024, 100f);
        String expected = String.format("Автор: Test User, дата: 1.1.2024\nФИО: Пупкин Александр Олегович 3, дата: 1.1.2024, сумма: 100.0");
        assertEquals(expected, report.toString());
    }


}
