package creational.builder.facade_builder;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

class Loan
{
    // Client
    public String firstName;
    public String lastName;
    public int age;

    // Loan detail information
    public double amount;
    public Date firstPaymentDate;
    public String currency;

    // Client rating
    public int ratingScore;
    public boolean inBlackList;

    @Override
    public String toString() {
        return "Loan{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", amount=" + amount +
                ", firstPaymentDate=" + firstPaymentDate +
                ", currency='" + currency + '\'' +
                ", ratingScore=" + ratingScore +
                ", inBlackList=" + inBlackList +
                '}';
    }
}
class LoanBuilder
{
    protected Loan loan = new Loan(); //Reference

    public ClientBuilder client()
    {
        return new ClientBuilder(this.loan);
    }

    public DetailBuilder detail()
    {
        return new DetailBuilder(this.loan);
    }

    public RatingBuilder rating()
    {
        return new RatingBuilder(this.loan);
    }

    public Loan save()
    {
        return this.loan;
    }
}
class RatingBuilder extends LoanBuilder
{
    public RatingBuilder(Loan loan)
    {
        this.loan = loan;
    }
    public RatingBuilder inBlackList(boolean inBlackList)
    {
        loan.inBlackList = inBlackList;
        return this;
    }
    public RatingBuilder ratingScore(int ratingScore)
    {
        loan.ratingScore = ratingScore;
        return this;
    }
}
class DetailBuilder extends LoanBuilder
{
    public DetailBuilder(Loan loan)
    {
        this.loan = loan;
    }
    public DetailBuilder amount(Double amount)
    {
        loan.amount = amount;
        return this;
    }
    public DetailBuilder firstPaymentDate(Date firstPaymentDate)
    {
        loan.firstPaymentDate = firstPaymentDate;
        return this;
    }
    public DetailBuilder currency(String  currency)
    {
        loan.currency = currency;
        return this;
    }
}
class ClientBuilder extends LoanBuilder
{
    public ClientBuilder(Loan loan)
    {
        this.loan = loan;
    }
    public ClientBuilder firstName(String firstName)
    {
        loan.firstName = firstName;
        return this;
    }
    public ClientBuilder lastName(String lastName)
    {
        loan.lastName = lastName;
        return this;
    }
    public ClientBuilder age(int age)
    {
        loan.age = age;
        return this;
    }
}
public class Main {
    public static void main(String[] args) {
        LoanBuilder lb =  new LoanBuilder();
        Loan loan1 = lb.client().firstName("Alan").lastName("Turing").age(55)
                .detail().amount(450000.0).currency("EUR").firstPaymentDate(new Date(2022, Calendar.FEBRUARY,1))
                .rating().ratingScore(5).inBlackList(false)
                .save();
        System.out.println(loan1);
    }
}
