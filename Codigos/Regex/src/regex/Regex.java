
package regex;
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;


public class Regex {

  //definir constantes a usar 
  private static final String PALABRA = "(a-z)*";  //cualquier letra de la 'a' a la 'z'
  private static final String  ESPACIO= "\\b"; 
     
  private static final String DIGITOS= "\\d";   //numeros del 0 al 9     
  private static final String SIGNOS="\\p{Punct}";//eliminar signos de puntuacion
 
  //Eliminar Tildes
  private static final String TILDEA="(á|ä|à)";
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
  private static final String ART1= ESPACIO+"(en)"+ESPACIO;
  private static final String ART2= ESPACIO+"(el)"+ESPACIO;
  private static final String ART3= ESPACIO+"(la)"+ESPACIO;
  private static final String ART4= ESPACIO+"(lo)"+ESPACIO;
  private static final String ART5= ESPACIO+"(un)"+ESPACIO;
  private static final String ART6= ESPACIO+"(uno)"+ESPACIO;
  private static final String ART7= ESPACIO+"(una)"+ESPACIO;

  
  //Pronombres
   private static final String PRON1= ESPACIO+"(est)+(a|e|o)"+ESPACIO;
   private static final String PRON2= ESPACIO+"(es)+(a|e|o)"+ESPACIO;
   private static final String PRON3= ESPACIO+"(aquel)+(la|lo)"+ESPACIO;
   private static final String PRON4= ESPACIO+"(vuestr)+(a|o)"+ESPACIO;
   private static final String PRON5= ESPACIO+"(nuestr)+(a|o)"+ESPACIO;
   private static final String PRON6= ESPACIO+"(mi)+(a|o)"+ESPACIO;
   private static final String PRON7= ESPACIO+"(tuy)+(a|o)"+ESPACIO;
   private static final String PRON8= ESPACIO+"(suy)+(a|o)"+ESPACIO;
   private static final String PRON9= ESPACIO+"dos"+ESPACIO;
   private static final String PRON10= ESPACIO+"tres"+ESPACIO;
   private static final String PRON11= ESPACIO+"cuatro"+ESPACIO;
   private static final String PRON12= ESPACIO+"tercer+(a|o)"+ESPACIO;
   private static final String PRON13= ESPACIO+"segund+(a|o)"+ESPACIO;
   private static final String PRON14= ESPACIO+"primer+(a|o)"+ESPACIO;
   private static final String PRON15= ESPACIO+"alguien"+ESPACIO;
   private static final String PRON16= ESPACIO+"nadie"+ESPACIO;
   private static final String PRON17= ESPACIO+"nada"+ESPACIO;
   private static final String PRON18= ESPACIO+"algo"+ESPACIO;
   private static final String PRON19= ESPACIO+"algun+(a|o)"+ESPACIO;
   private static final String PRON20= ESPACIO+"otr+(a|o)"+ESPACIO;
   private static final String PRON21= ESPACIO+"vari+(a|o)"+ESPACIO;
   private static final String PRON22= ESPACIO+"much+(a|o)"+ESPACIO;
   private static final String PRON23= ESPACIO+"poc+(a|o)"+ESPACIO;
   private static final String PRON24= ESPACIO+"pre"+ESPACIO;
   private static final String PRON25= ESPACIO+"para"+ESPACIO;
   private static final String PRON26= ESPACIO+"yo"+ESPACIO;
   private static final String PRON27= ESPACIO+"me"+ESPACIO;
   private static final String PRON28= ESPACIO+"mi"+ESPACIO;
   private static final String PRON29= ESPACIO+"conmigo"+ESPACIO;
   private static final String PRON30= ESPACIO+"consigo"+ESPACIO;
   private static final String PRON31= ESPACIO+"nosotr+(o|a)"+ESPACIO;
   private static final String PRON32= ESPACIO+"vosotr+(o|a)"+ESPACIO;
   private static final String PRON33= ESPACIO+"tu"+ESPACIO;
   private static final String PRON34= ESPACIO+"te"+ESPACIO;
   private static final String PRON35= ESPACIO+"ti"+ESPACIO;
   private static final String PRON36= ESPACIO+"ell+(a|o)"+ESPACIO;
   private static final String PRON37= ESPACIO+"se"+ESPACIO;
   private static final String PRON38= ESPACIO+"se"+ESPACIO;
   private static final String PRON39= ESPACIO+"si"+ESPACIO;
   private static final String PRON40= ESPACIO+"le"+ESPACIO;
  
//Sufijos Sustantivos  
    private static final String SS1= PALABRA+"aje"+ESPACIO;
    private static final String SS2= PALABRA+"(e|a)ncia"+ESPACIO;
    private static final String SS3= PALABRA+"(a|e|ie)nte"+ESPACIO;
    private static final String SS4= PALABRA+"a(l|r)"+ESPACIO;
    private static final String SS5= PALABRA+"ari(a|e)"+ESPACIO;
    private static final String SS6= PALABRA+"cion"+ESPACIO;
    private static final String SS7= PALABRA+"dad"+ESPACIO;
    private static final String SS8= PALABRA+"do(r|ra)"+ESPACIO;
    private static final String SS9= PALABRA+"eda"+ESPACIO;
    private static final String SS10= PALABRA+"eria"+ESPACIO;
    private static final String SS11= PALABRA+"er(a|o)"+ESPACIO;
    private static final String SS12= PALABRA+"ez"+ESPACIO;
    private static final String SS13= PALABRA+"ista"+ESPACIO;
    private static final String SS14= PALABRA+"ura"+ESPACIO;
    private static final String SS15= PALABRA+"emo"+ESPACIO;
    
 //Sufijos de Verbos 
    private static final String SV1= PALABRA+"ear"+ESPACIO;
    private static final String SV2= PALABRA+"ecer"+ESPACIO;
    private static final String SV3= PALABRA+"ificaer"+ESPACIO;
    private static final String SV4= PALABRA+"izar"+ESPACIO;
   
 //Aumentativos
    private static final String AUM1= PALABRA+"azo"+ESPACIO;
    private static final String AUM2= PALABRA+"o(n|a)"+ESPACIO;
    private static final String AUM3= PALABRA+"ote"+ESPACIO;
  
 //Diminutivos
    private static final String DIM1= PALABRA+"it(a|o)"+ESPACIO;
    private static final String DIM2= PALABRA+"ill(a|o)"+ESPACIO;
    private static final String DIM3= PALABRA+"ic(a|o)"+ESPACIO;
    private static final String DIM4= PALABRA+"uelo(a|o)"+ESPACIO;
    private static final String DIM5= PALABRA+"i(n|na)"+ESPACIO;

//Despectivos
     private static final String DESP1= PALABRA+"ac(a|o)"+ESPACIO;
     private static final String DESP2= PALABRA+"ach(a|o)"+ESPACIO;
     private static final String DESP3= PALABRA+"aj(a|o)"+ESPACIO;
     private static final String DESP4= PALABRA+"astr(a|o)"+ESPACIO;
     private static final String DESP5= PALABRA+"uch(a|o)"+ESPACIO;
     
//Adjetivo
     private static final String ADJ1= PALABRA+"able"+ESPACIO;
     private static final String ADJ2= PALABRA+"ient(a|o)"+ESPACIO;
     private static final String ADJ3= PALABRA+"il"+ESPACIO;
     private static final String ADJ4= PALABRA+"in(a|o)"+ESPACIO;
     private static final String ADJ5= PALABRA+"iz(o|a)"+ESPACIO;
     private static final String ADJ6= PALABRA+"os(a|o)"+ESPACIO;
     private static final String ADJ7= PALABRA+"ud(a|o)"+ESPACIO;
     private static final String ADJ8= PALABRA+"ible"+ESPACIO;
     private static final String ADJ9= PALABRA+"ad(a|o)"+ESPACIO;
     private static final String ADJ10= PALABRA+"id(a|o)"+ESPACIO;
     private static final String ADJ11= PALABRA+"an(a|o)"+ESPACIO;
     private static final String ADJ12= PALABRA+"al"+ESPACIO;
     private static final String ADJ13= PALABRA+"ar"+ESPACIO;
     private static final String ADJ14= PALABRA+"ens(a|e)"+ESPACIO;
     private static final String ADJ15= PALABRA+"eñ(a|o)"+ESPACIO;
    
//eliminar s
  private static final String ELIMINARS= "[s]\\b";
  
  public String ElimPuntuacion(String Texto)
  {
      Pattern sigpunt=Pattern.compile(SIGNOS); //Se da el patron a Buscar
      
      Matcher coincidencia=sigpunt.matcher(Texto);//Se buscan Coincidencias
      Texto= coincidencia.replaceAll(" ");//se reeemplazan las cioncidencias con un espacio vacio
      
      return Texto;
  }
  
  public String ElimDigit(String Texto)
  {
      Pattern digit=Pattern.compile(DIGITOS);
      Matcher coincidencia=digit.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      return Texto;
      
  }
  
  public String EliminarS(String Texto)
  {
      Pattern elims=Pattern.compile(ELIMINARS);
      
      Matcher coincidencia=elims.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
  }
  
  public String ElimTildes(String Texto)
  {
        Matcher coincidencia;
        Pattern elimtilde;
        
        elimtilde = Pattern.compile(TILDEA);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(REEMPLAZOA);
                
        elimtilde=Pattern.compile(TILDEE);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(REEMPLAZOE);
        
        elimtilde=Pattern.compile(TILDEI);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(REEMPLAZOI);
        
        elimtilde=Pattern.compile(TILDEO);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(REEMPLAZOO);
        
        elimtilde=Pattern.compile(TILDEU);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(REEMPLAZOU);
        
      
      return Texto;
  }  
  
  public String ElimPrefijos(String Texto)
  {
      Pattern epref;
      Matcher coincidencia;
      
      epref=Pattern.compile(PREF1);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF2);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF3);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF4);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF5);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF6);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF7);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF8);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF9);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF10);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF11);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF12);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF13);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF14);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF15);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF16);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF17);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF18);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF19);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       epref=Pattern.compile(PREF20);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      return Texto;
      
  }
  
  
  public String ElimArticulos(String Texto)
  {
      Pattern eart;
      Matcher coincidencia;
      
      eart=Pattern.compile(ART1);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      eart=Pattern.compile(ART2);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      eart=Pattern.compile(ART3);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      eart=Pattern.compile(ART4);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      eart=Pattern.compile(ART5);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      eart=Pattern.compile(ART6);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      eart=Pattern.compile(ART7);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
       
      return Texto;
  }
  
  public String ElimPronombres(String Texto)
  {
      Pattern epron;
      Matcher coincidencia;
      
      epron= Pattern.compile(PRON1);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON2);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON3);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON4);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON5);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON6);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON7);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON8);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON9);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON10);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON11);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON12);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON13);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON14);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      
      epron= Pattern.compile(PRON15);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON16);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON17);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON18);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON19);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON20);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON21);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON22);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON23);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON24);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON25);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON26);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON27);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON28);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON29);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON30);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON31);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON32);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON33);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON34);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON35);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON36);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON37);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON38);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON39);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      epron= Pattern.compile(PRON40);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      
      return Texto;
      
  }
  
    public String ElimSufijos(String Texto)
  {
      Pattern esufijos;
      Matcher coincidencia;
      
      //Suf. Sustantivos
      esufijos= Pattern.compile(SS1);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS2);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS3);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS4);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(SS5);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS6);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS7);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS8);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS9);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS10);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS11);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS12);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS13);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SS14);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(SS15);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
   
   
      
      //Suf. Verbos
      
      esufijos= Pattern.compile(SV1);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SV2);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(SV3);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(SV4);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      //Aumentativos
      
      esufijos= Pattern.compile(AUM1);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(AUM2);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(AUM3);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      
      //Diminutivos
      
      esufijos= Pattern.compile(DIM1);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(DIM2);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(DIM3);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(DIM4);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
       esufijos= Pattern.compile(DIM5);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      //Despectivo
      
      esufijos= Pattern.compile(DESP1);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(DESP2);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(DESP3);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(DESP4);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(DESP5);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      //Adjetivo
      
      esufijos= Pattern.compile(ADJ1);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ2);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ3);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ4);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ5);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ6);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ7);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ8);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ9);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ10);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ11);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ12);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ13);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ14);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      esufijos= Pattern.compile(ADJ15);
      coincidencia=esufijos.matcher(Texto);
      Texto=coincidencia.replaceAll(" ");
      
      
      return Texto;
      
  }
  
  public static void main(String[] args)throws FileNotFoundException
  {
      Scanner sc = new Scanner(System.in);
      String linea = sc.nextLine();
      String txt = linea.toLowerCase();
      Regex x=new Regex();
      
      txt=x.EliminarS(txt);
      txt=x.ElimDigit(txt);
      txt=x.ElimPuntuacion(txt);
      txt=x.ElimTildes(txt);
      txt=x.ElimArticulos(txt);
      txt=x.ElimPrefijos(txt);
      txt=x.ElimPronombres(txt);
      txt=x.ElimSufijos(txt);
      
      
      System.out.println("\n\n\n\n"+ txt);
  
  }
  
}
