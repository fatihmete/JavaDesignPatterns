package creational.builder.static_builder;

public class Client {

    private final String firstName;
    private final String lastName;
    private final String country;
    private final int age;
    private final boolean isLoyal;
    private final double lastCheckout;

    public Client(ClientBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.country = builder.country;
        this.age = builder.age;
        this.isLoyal = builder.isLoyal;
        this.lastCheckout = builder.lastCheckout;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", isLoyal=" + isLoyal +
                ", lastCheckout=" + lastCheckout +
                '}';
    }

    public static class ClientBuilder
    {
        private String firstName;
        private String lastName;
        private String country;
        private int age;
        private boolean isLoyal;
        private double lastCheckout;

        public ClientBuilder(String firstName)
        {
            //Mandatory fields
            this.firstName = firstName;
        }

        public ClientBuilder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }
        public ClientBuilder country(String country)
        {
            this.country = country;
            return this;
        }
        public ClientBuilder age(int age)
        {
            this.age = age;
            return this;
        }
        public  ClientBuilder isLoyal(boolean isLoyal)
        {
            this.isLoyal = isLoyal;
            return this;
        }
        public ClientBuilder lastCheckout(double lastCheckout)
        {
            this.lastCheckout = lastCheckout;
            return this;
        }

        public Client build()
        {
            return new Client(this);
        }
    }
}

class Main{
    public static void main(String[] args) {
        Client test1 = new Client.ClientBuilder("Mary")
                .age(22)
                .lastName("Lennon")
                .country("Paris")
                .lastCheckout(45.50)
                .isLoyal(true)
                .build();
        System.out.println(test1);

        Client test2 = new Client.ClientBuilder("Mary")
                .age(22)
                .lastName("Lennon")
                .build();
        System.out.println(test2);


    }
}
