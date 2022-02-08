package creational.builder;

public class StringBuilder {


    public static void main(String[] args) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        String[] words = {"apple", "pineapple", "cheese", "yoghurt"};
        sb.append("<ul>\n");
        for(String word:words)
        {
            sb.append(String.format("\t<li>%s</li>\n",word));
        }
        sb.append("</ul>");
        System.out.println(sb);


    }
}
