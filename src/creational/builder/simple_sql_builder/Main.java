package creational.builder.simple_sql_builder;

import java.util.ArrayList;
import java.util.Arrays;

//TODO Change this as QueryBuilder and move build() method here.
class Query
{
    String query;
    public Query(String query)
    {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Query{" +
                "query='" + query + '\'' +
                '}';
    }
}
// TODO Change this as StatementBuilder
class QueryBuilder
{
    private String tableName;
    private ArrayList<String> whereStatement = new ArrayList<>();
    private ArrayList<String> selectStatement = new ArrayList<>();
    private ArrayList<String> groupByStatemnt = new ArrayList<>();

    public QueryBuilder() { }

    public QueryBuilder table(String tableName)
    {
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder where (String... conditions)
    {
        this.whereStatement.addAll(Arrays.asList(conditions));
        return this;
    }

    public QueryBuilder select(String... columns)
    {
        this.selectStatement.addAll(Arrays.asList(columns));
        return this;
    }

    public QueryBuilder groupBy(String... groups)
    {
        this.groupByStatemnt.addAll(Arrays.asList(groups));
        return this;
    }

    public Query get() throws Exception
    {
        String query = "";
        // Select Builder
        if(this.selectStatement.size()>0)
        {
            query += String.format("SELECT %s",String.join(", ", this.selectStatement));
        }
        else{
            query += "SELECT * ";
        }
        // Set table name
        if(this.tableName == null)
        {
            throw new Exception("You must set table parameter.");
        }
        else
        {
            query += " FROM " + this.tableName;
        }
        // Where Builder
        if(this.whereStatement.size()>0)
        {
            query += String.format(" WHERE %s",String.join(" AND ", this.whereStatement));
        }
        // Group By Builder
        if(this.groupByStatemnt.size()>0)
        {
            query += String.format(" GROUP BY %s",String.join(", ", this.groupByStatemnt));
        }

        return new Query(query);
    }

}

public class Main {

    public static void main(String[] args) throws Exception {

        QueryBuilder simpleQueryBuilder = new QueryBuilder();
        Query sq = simpleQueryBuilder.table("users")
                .get();
        System.out.println(sq);

        QueryBuilder complexQueryBuilder = new QueryBuilder();
        Query q = complexQueryBuilder.table("users")
                .select("city")
                .select("avg(age) as AverageAge")
                .where("name like 'A%'", "age>20")
                .where("city='Berlin'")
                .groupBy("city")
                .get();
        System.out.println(q);

    }
}
