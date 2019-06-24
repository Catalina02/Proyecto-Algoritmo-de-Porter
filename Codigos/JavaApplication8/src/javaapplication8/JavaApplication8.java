package javaapplication8;


import java.util.regex.*;
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;

public class JavaApplication8{
    /////////////////////Reemplazo y/o eliminación de caracteres especiales/////////////////////
    private static final String letras="(a-z)"; //todas las letras, desde la a hasta la z
    private static final String findepalabra="\\b"; //reconoce espacios para definir como fin o inicio de palabra
    private static final String puntuacion="\\p{Punct}";//elimina signos de puntuación
    private static final String numeros="\\d";//elimina numeros
    private static final String caracteresA="[á|ä|à|â]"; //reconoce 'a'es con caracteres especiales
    private static final String caracteresE="[é|ë|è|ê]"; //reconoce 'e'es con caracteres especiales
    private static final String caracteresI="[í|ï|ì|î]"; //reconoce 'i'es con caracteres especiales
    private static final String caracteresO="[ó|ö|ò|ô]"; //reconoce 'o'es con caracteres especiales
    private static final String caracteresU="[ú|ü|ù|û]"; //reconoce 'u'es con caracteres especiales
    /////////////////////Eliminación de prefijos/////////////////////
    private static final String prefijoAn=findepalabra+"(an)"+letras+"*";
    private static final String prefijoAnt=findepalabra+"(ant[e|i])"+letras+"*";
    private static final String prefijoBi=findepalabra+"(bi[s]*)"+letras+"*";
    private static final String prefijoCo=findepalabra+"(co[n]*)"+letras+"*";
    private static final String prefijoContra=findepalabra+"(contra)"+letras+"*";
    private static final String prefijoDe=findepalabra+"(de[s]*)"+letras+"*";
    private static final String prefijoEn=findepalabra+"(en)"+letras+"*";
    private static final String prefijoEntre=findepalabra+"(entre)"+letras+"*";
    private static final String prefijoEx=findepalabra+"(ex)"+letras+"*";
    private static final String prefijoExtra=findepalabra+"(extra)"+letras+"*";
    private static final String prefijoHiper=findepalabra+"(hiper)"+letras+"*";
    private static final String prefijoHipo=findepalabra+"(hipo)"+letras+"*";
    private static final String prefijoIn=findepalabra+"(in)"+letras+"*";
    private static final String prefijoInter=findepalabra+"(inter)"+letras+"*";
    private static final String prefijoPost=findepalabra+"(post)"+letras+"*";
    private static final String prefijoPre=findepalabra+"(pre)"+letras+"*";
    private static final String prefijoRe=findepalabra+"(re)"+letras+"*";
    private static final String prefijoSub=findepalabra+"(sub)"+letras+"*";
    private static final String prefijoSuper=findepalabra+"(super)"+letras+"*";
    /////////////////////Eliminación de Sufijos/////////////////////
    private static final String sufijoAzo=(letras+"*([a|i][z|d|n]o)"+findepalabra);
    private static final String sufijoOn=(letras+"*([i|o]n)"+findepalabra);
    private static final String sufijoOte=(letras+"*(ote)"+findepalabra);
    private static final String sufijoAble=(letras+"*([i|a]ble)"+findepalabra);
    private static final String sufijoAl=(letras+"*(a[l|r])"+findepalabra);
    private static final String sufijoEnse=(letras+"*(en[s|t]e)"+findepalabra);
    private static final String sufijoEño=(letras+"*([a|e]ño)"+findepalabra);
    private static final String sufijoIble=(letras+"*([a|i]ble)"+findepalabra);
    private static final String sufijoIdo=(letras+"*([i|u]do)"+findepalabra);
    private static final String sufijoIl=(letras+"*(il)"+findepalabra);
    private static final String sufijoIno=(letras+"*(i[n|z|t]o)"+findepalabra);
    private static final String sufijoOso=(letras+"*(oso)"+findepalabra);
    private static final String sufijoAje=(letras+"*(aj[o|e])"+findepalabra);
    private static final String sufijoAncia=(letras+"*(ancia)"+findepalabra);
    private static final String sufijoAnte=(letras+"*(ante)"+findepalabra);
    /////////////////////Eliminación de pronombres/////////////////////
    private static final String pronombreAlguien=(findepalabra+"alguien"+findepalabra);
    private static final String pronombreAlgun=(findepalabra+"algun[os|as]*"+findepalabra);
    private static final String pronombreAquel=(findepalabra+"aquel"+findepalabra);
    private static final String pronombreAquell=(findepalabra+"aquell[o|a][s]*"+findepalabra);
    private static final String pronombreBastante=(findepalabra+"bastante[s]*"+findepalabra);        
    private static final String pronombreConmigo=(findepalabra+"con[m|s]igo"+findepalabra);
    private static final String pronombreDos=(findepalabra+"dos"+findepalabra);
    private static final String pronombreTres=(findepalabra+"tres"+findepalabra);
    private static final String pronombreCuatro=(findepalabra+"cuatro"+findepalabra);
    private static final String pronombreCinco=(findepalabra+"cinco"+findepalabra);
    private static final String pronombreSeis=(findepalabra+"seis"+findepalabra);
    private static final String pronombreSiete=(findepalabra+"siete"+findepalabra);
    private static final String pronombreOcho=(findepalabra+"ocho"+findepalabra);
    private static final String pronombreNueve=(findepalabra+"nueve"+findepalabra);
    private static final String pronombreEllo=(findepalabra+"ell[o|a][s]*"+findepalabra);
    private static final String pronombreEso=(findepalabra+"es[o|a][s]*"+findepalabra);
    private static final String pronombreEse=(findepalabra+"es[t]*e"+findepalabra);
    private static final String pronombreEsto=(findepalabra+"est[o|a][s]*"+findepalabra);
    private static final String pronombreLo=(findepalabra+"l[o|a|e][s]*"+findepalabra);
    private static final String pronombreMi=(findepalabra+"mi[o|a][s]*"+findepalabra);
    private static final String pronombreMucho=(findepalabra+"much[o|a][s]*"+findepalabra);
    private static final String pronombreNada=(findepalabra+"nada"+findepalabra);
    private static final String pronombreNadie=(findepalabra+"nadie"+findepalabra);
    private static final String pronombreNingun=(findepalabra+"ningun"+findepalabra);
    private static final String pronombreNinguno=(findepalabra+"ningun[o|a][s]*"+findepalabra);
    private static final String pronombreNuestro=(findepalabra+"nuestr[o|a][s]*"+findepalabra);
    private static final String pronombreOtro=(findepalabra+"otr[o|a][s]*"+findepalabra);
    private static final String pronombrePara=(findepalabra+"para"+findepalabra);
    private static final String pronombrePoco=(findepalabra+"poc[o|a][s]*"+findepalabra);
    private static final String pronombrePrimer=(findepalabra+"primer[os|as]*"+findepalabra);
    private static final String pronombreSe=(findepalabra+"s[e|i|u]"+findepalabra);
    private static final String pronombreSegund=(findepalabra+"segund[o|a][s]*"+findepalabra);
    private static final String pronombreSuyo=(findepalabra+"suy[o|a][s]*"+findepalabra);
    private static final String pronombreTe=(findepalabra+"t[e|i|u]"+findepalabra);
    private static final String pronombreTercer=(findepalabra+"tercer[os|as]*"+findepalabra);
    private static final String pronombreToda=(findepalabra+"tod[o|a][s]*"+findepalabra);
    private static final String pronombreTuyo=(findepalabra+"tuy[o|a][s]*"+findepalabra);
    private static final String pronombreUn=(findepalabra+"un"+findepalabra);
    private static final String pronombreUno=(findepalabra+"un[o|a][s]*"+findepalabra);
    private static final String pronombreVarios=(findepalabra+"vari[o|a][s]*"+findepalabra);
    private static final String pronombreVosotros=(findepalabra+"vosotr[o|a][s]*"+findepalabra);
    private static final String pronombreVuestro=(findepalabra+"vuestr[o|a][s]*"+findepalabra);
    private static final String pronombreYo=(findepalabra+"yo"+findepalabra);
    private static final String pronombreComo=(findepalabra+"como"+findepalabra);
    /////////////////////Eliminación de Monosilabos/////////////////////
    private static final String articuloEn = findepalabra+"en"+findepalabra;
    private static final String articuloEl = findepalabra+"el"+findepalabra;
    private static final String articuloLa = findepalabra+"la"+findepalabra;
    private static final String articuloLos = findepalabra+"los"+findepalabra;
    private static final String articuloLas = findepalabra+"las"+findepalabra;
    private static final String articuloLo = findepalabra+"lo"+findepalabra;
    private static final String articuloUn = findepalabra+"un"+findepalabra;
    private static final String articuloUnos = findepalabra+"unos"+findepalabra;
    private static final String articuloUna = findepalabra+"una"+findepalabra;
    private static final String articuloUnas = findepalabra+"unas"+findepalabra;
    
    public String borrarTildes(String texto){
        String reemplazo;
        Pattern Atilde = Pattern.compile(caracteresA);
        Pattern Etilde = Pattern.compile(caracteresE);
        Pattern Itilde = Pattern.compile(caracteresI);    //detectando las vocales con acentos y otros
        Pattern Otilde = Pattern.compile(caracteresO);
        Pattern Utilde = Pattern.compile(caracteresU);
        Matcher empareja; //declaración de una clase empareja, la cual contiene métodos para encontrar patrones
        empareja=Atilde.matcher(texto);      
        reemplazo=empareja.replaceAll("a");  //reemplazando por 'a'
        empareja=Etilde.matcher(reemplazo);
        reemplazo=empareja.replaceAll("e");  //reemplazando por 'e'
        empareja=Itilde.matcher(reemplazo);
        reemplazo=empareja.replaceAll("i");  //reemplazando por 'i'
        empareja=Otilde.matcher(reemplazo); 
        reemplazo=empareja.replaceAll("o");  //reemplazando por 'o'
        empareja=Utilde.matcher(reemplazo);
        reemplazo=empareja.replaceAll("u");  //reemplazando por 'u'
        return reemplazo;
    }
    public String borrarPuntuacionYNumeros(String texto){
        Pattern puntos=Pattern.compile(puntuacion);
        Pattern digitos=Pattern.compile(numeros);
        Matcher empareja; //declaración de una clase Matcher, la cual contiene métodos para encontrar patrones
        String reemplazo;
        empareja=puntos.matcher(texto);
        reemplazo=empareja.replaceAll("");   //reemplazo de puntuaciones por espacio en blanco
        empareja=digitos.matcher(reemplazo);
        reemplazo=empareja.replaceAll("");   //reemplazo de digitos por espacio en blanco
        return reemplazo;
    }
 
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          Scanner sc = new Scanner(System.in);
      String txt = sc.nextLine();
      JavaApplication8 x=new JavaApplication8();
     // txt=x.EliminarS(txt);
      //txt=x.ElimPuntuacion(txt);
     txt=x.borrarTildes(txt);
   
      System.out.println(txt);
    }
    
}
