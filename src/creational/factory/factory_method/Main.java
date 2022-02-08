package creational.factory.factory_method;

class Query
{
    private String query;
    private String dataSource;

    private Query(String query, String dataSource)
    {
        this.query = query;
        this.dataSource = dataSource;
    }

    public void run()
    {
        System.out.println(this.query + " is running on " + this.dataSource);
    }

    public static Query newMysqlQuery(String query)
    {
        return new Query(query, "mysql_connection");
    }

    public static Query newHiveQuery(String query)
    {
        return new Query(query,"hive_connection");
    }

}

public class Main {
    public static void main(String[] args) {

        Query hive = Query.newHiveQuery("select * from users;");
        hive.run();

        Query mysql = Query.newMysqlQuery("select * from users;");
        mysql.run();
    }
}
