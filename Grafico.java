package desafio_charts;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class HTML {
    private int Coluna;
    private int Linha;
    private static String vetor[][]= new String[3][2];

    public String[][] getVetor() {
        return vetor;
    }

    public void setVetor(String[][] vetor) {
        this.vetor = vetor;
    }

    
    
    

    public int getColuna() {
        return Coluna;
    }

    public void setColuna(int Coluna) {
        this.Coluna = Coluna;
    }

    public int getLinha() {
        return Linha;
    }

    public void setLinha(int Linha) {
        this.Linha = Linha;
    }
    
    
    public static String cabecalho() {
          HTML dt = new HTML();
          int linha = dt.getLinha();
          int coluna = dt.getColuna();
	  StringBuilder html = new StringBuilder(); 
	  html.append("<html>\n");
	  html.append(" <head><title>DesafioPoo1</title>\n");
	  html.append("    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
          html.append("    <script type=\"text/javascript\">\n");
          html.append("      google.charts.load(\'current\', {\'packages\':[\'corechart\']});\n");
          html.append("      google.charts.setOnLoadCallback(drawChart);\n");
          html.append("\n      function drawChart() {");
          html.append("\n       var data = google.visualization.arrayToDataTable([");
          html.append("\n          [\'").append(vetor[0][0]).append("\',\'").append(vetor[0][1]).append("\',\'").append(vetor[0][2]).append("\'],");
          html.append("\n          [\'").append(vetor[1][0]).append("\',").append(vetor[1][1]).append(",").append(vetor[1][2]).append("],");
          html.append("\n          [\'").append(vetor[2][0]).append("\',").append(vetor[2][1]).append(",").append(vetor[2][2]).append("],");
          html.append("\n          [\'").append(vetor[3][0]).append("\',").append(vetor[3][1]).append(",").append(vetor[3][2]).append("],");
          html.append("\n          [\'").append(vetor[4][0]).append("\',").append(vetor[4][1]).append(",").append(vetor[4][2]).append("],");
          html.append("         ]);\n");
	  return html.toString();
    }
    
    public static String rodape() {
	  StringBuilder html = new StringBuilder();
          html.append("        var options = {\n");
          html.append("          title: \'Company Performance\',\n");
          html.append("          hAxis: {title: \'Year\',  titleTextStyle: {color: \'#333\'}},\n");
          html.append("          vAxis: {minValue: 0}\n");
          html.append("        };\n");
          html.append("        var chart = new google.visualization.AreaChart(document.getElementById(\'chart_div\'));\n");
          html.append("        chart.draw(data, options);\n");
          html.append("      }\n");
	  html.append("    </script>\n");
          html.append("  </head>\n");
	  html.append("  <body>\n");
          html.append("    <div id=\"chart_div\" style=\"width: 100%; height: 500px;\"></div>\n");
          html.append("  </body>\n");
          html.append("</html>\n");
	  return html.toString();
  }    
     public void gerarHTML() throws IOException{
      
            

            
            File file = new File("Inicio0.html");

           
            if (!file.exists()) {
                file.createNewFile();
            }

           
            FileWriter arquivo = new FileWriter(file.getAbsoluteFile());
            PrintWriter gravar_arquivo = new PrintWriter(arquivo);
            
         
            StringBuilder html = new StringBuilder(); 
            html.append(cabecalho());
            html.append(rodape());
            html.toString();
      
            gravar_arquivo.printf("%s\n",html);
            arquivo.close();
    }
}
