package HTML;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Exerc_Charts.Grafico;

public class Arquivo {

		private final String PATH = "gráficos/";
		
		private String style = " ";
		
		public void grava(String fileName, String titulo, String temp) throws IOException {
		    FileWriter arquivo = new FileWriter(this.PATH.concat(fileName).concat(".html"));
		    PrintWriter persistir = new PrintWriter(arquivo);

		    persistir.printf("%s\n", cabecalho(fileName, titulo, temp));
		    persistir.printf("%s\n", corpo(fileName));
		    persistir.printf("%s\n", rodape());

		    arquivo.close();
		  }
		
		private String cabecalho(String type, String titulo, String temp) throws IOException {
		    StringBuilder html = new StringBuilder();

		    html.append("<!DOCTYPE html>\n");
		    html.append("<html>\n");
		    html.append("<head>\n");
		    html.append("<title>");
		    html.append(type);
		    html.append("</title>\n");

		    html.append(script(type, titulo, temp));

		    html.append("</head>\n");

		    return html.toString();
		  }
		
		private String rodape() {
		    StringBuilder html = new StringBuilder();
		    html.append("</html>\n");
		    return html.toString();
		  }
		
		private String corpo(String style) {
		    StringBuilder html = new StringBuilder();

		    html.append("<body>\n");
		    html.append("<div \n");
		    html.append("id=\"chart_div\" style=\"");
		    html.append(this.style);
		    html.append("\">\n");
		    html.append("</div>\n");
		    html.append("</body>\n");

		    return html.toString();
		  }
		
		private StringBuilder script(String titulo, String titulo2, String temp) throws IOException {
		    StringBuilder html = new StringBuilder();

		    html.append("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
		    html.append("<script type=\"text/javascript\">\n");
		    html.append("google.charts.load('current', {'packages':['corechart']});\n");
		    html.append("google.charts.setOnLoadCallback(drawChart);\n");

		    html.append(functionDrawJS(titulo, titulo, temp));

		    html.append("</script>\n");

		    return html;
		  }
		
		private StringBuilder functionDrawJS(String type, String titulo, String temp) throws IOException {
		    StringBuilder html = new StringBuilder();
		   
		    html.append("function drawChart() {\n");
		    html.append("var data = google.visualization.arrayToDataTable([\n");

		    html.append(temp(type));

		    html.append("]);\n");

		    html.append("var options = {\n");
		    html.append("title: '");
		    html.append(titulo);
		    html.append("',\n");
		    html.append("LineChart");
		    html.append(this.style = "width: 900px; height: 500px");

		    html.append("curveType: 'function',");
		    html.append("legend: { position: 'bottom' }");
		          
		    html.append("};\n");

		    html.append("var chart = new google.visualization.");
		    html.append(type);
		    html.append("(document.getElementById('chart_div'));\n");
		    html.append("chart.draw(data, options);\n");
		    html.append("}\n");
		    return html;
		  }
		
		private StringBuilder temp(String type) throws IOException {
		    StringBuilder html = new StringBuilder();

		    html.append("LineChart");
		    html.append("[");
		    html.append("'");
		        
		    html.append("',");
		       
		         
		    html.append("'");
		          
		    html.append("',");
		      
		       
		    html.append("],").deleteCharAt(html.length() - 3);
		        
		    return html.deleteCharAt(html.length() - 1);
		 }
}
