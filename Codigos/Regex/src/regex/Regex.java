
package regex;
import java.util.regex.*;

public class Regex {

  //definir constantes a usar 
  private static final String PALABRA = "(a-z)*";  //cualquier letra de la 'a' a la 'z'
  private static final String  ESPACIO= "\\b"; 
     
  private static final String DIGITOS= "\\d";   //numeros del 0 al 9     
  private static final String SIGNOS="\\p{Punct}";//eliminar signos de puntuacion
 
  //Eliminar Tildes
  private static final String TILDEA="[á|ä|â|à]";
  private static final String REEMPLAZOA="a";

  private static final String TILDEE="[é|ë|ê|è]";
  private static final String REEMPLAZOE="e";

  private static final String TILDEI="[í|ï|î|ì]";
  private static final String REEMPLAZOI="i";
  
  private static final String TILDEO="[ó|ö|ô|ò]";
  private static final String REEMPLAZOO="o";
  
  private static final String TILDEU="[ú|ü|û|ù]";
  private static final String REEMPLAZOU="u";
  
  //Prejijos
  
  private static final String PREF1= ESPACIO+"(an|a)"+PALABRA;
  private static final String PREF2= ESPACIO+"(ante)"+PALABRA;
  private static final String PREF3= ESPACIO+"(anti)"+PALABRA;
  private static final String PREF4= ESPACIO+"(bis|bi)"+PALABRA;
  private static final String PREF5= ESPACIO+"(con|co)"+PALABRA;
  private static final String PREF6= ESPACIO+"(contra)"+PALABRA;
  private static final String PREF7= ESPACIO+"(des|de)"+PALABRA;
  private static final String PREF8= ESPACIO+"(en)"+PALABRA;
  private static final String PREF9= ESPACIO+"(entre)"+PALABRA;
  private static final String PREF10= ESPACIO+"(ex)"+PALABRA;
  private static final String PREF11= ESPACIO+"(extra)"+PALABRA;
  private static final String PREF12= ESPACIO+"(hiper)"+PALABRA;
  private static final String PREF13= ESPACIO+"(hipo)"+PALABRA;
  private static final String PREF14= ESPACIO+"(in)"+PALABRA;
  private static final String PREF15= ESPACIO+"(inter)"+PALABRA;
  private static final String PREF16= ESPACIO+"(post|pos)"+PALABRA;
  private static final String PREF17= ESPACIO+"(pre)"+PALABRA;
  private static final String PREF18= ESPACIO+"(re)"+PALABRA;
  private static final String PREF19= ESPACIO+"(sub)"+PALABRA;
  private static final String PREF20= ESPACIO+"(super)"+PALABRA;

  
  //Articulos
//eliminar s
  private static final String ELIMINARS= "[s]\\b";
  
    
}
