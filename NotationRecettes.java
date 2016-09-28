/*
  Programme qui note des recettes. 
  Affichage des notes par moyenne avec le nombre d'avis. 
  Tri des recettes par ordre décroissant et croissant des notes de recettes.
  Possiblité d'ajouter et de retirer des recettes.
  Quitter le programme
  */



  //affichage par note décroissante
  public class NotationRecettes{
    public static void main(String[] args){
      String[] recettes={"","Eclair","Religieuse","Financier","Chouquette","Macaron"};
      double[] moynotes= new double[recettes.length];
      double[] nbvotant=new double[recettes.length];
      double[] totalnotes=new double[recettes.length];
      String[] menu={"","Affichage des recettes","Affichage des recettes par notes croissantes", "Affichage des recettes par notes décroissantes","Ajouter une note","Afficher la note d'une recette","Ajouter une recette","Supprimer une recette","Quitter le programme"};
      int choix;
      int indiceR=0;
      
      do{
        Terminal.ecrireString("****************************************************");
        Terminal.sautDeLigne();
        affTab(menu);
        Terminal.ecrireStringln("****************************************************");
        Terminal.ecrireStringln("Votre choix ?");
        choix=Terminal.lireInt();
        
        
        if (choix<=0 || choix>menu.length-1){
          msg(401,menu);
        }
        
        if (choix==1){
          affTab(recettes);
        }
        if (choix==2){
          String[] newRecettes= copieTab(recettes);
          double[] newMoynotes= copieTab(moynotes);
          double[] newNbvotant= copieTab(nbvotant); 
          double[] newtotalnotes= copieTab(totalnotes); 
          trieTabs1(newRecettes,newMoynotes,newNbvotant,newtotalnotes);
          afftab3(newRecettes,newMoynotes,newNbvotant);  
        }
        if (choix==3){
          String[] newR= copieTab(recettes);
          double[] newMoy= copieTab(moynotes);
          double[] newNbvot= copieTab(nbvotant); 
          double[] newtot= copieTab(totalnotes); 
          trieTabs2(newR,newMoy,newNbvot,newtot);
          afftab3(newR,newMoy,newNbvot);    
        }
        
        if (choix==4){
          double note; 
          double vote=1;
          do{
            affTab(recettes);
            Terminal.ecrireString("Quelle recette ?");
            indiceR=Terminal.lireInt();
          }while(verifError(indiceR,recettes)==1);
          do{
            Terminal.ecrireString("Attribuer une note entre 1 et 5 ?");
            note=Terminal.lireDouble();
          }while(verifError(note)==1);
          totalnotes[indiceR]=totalnotes[indiceR]+note;
          nbvotant[indiceR]=nbvotant[indiceR]+vote;
          moynotes[indiceR]=totalnotes[indiceR]/nbvotant[indiceR];
        }
        
        if (choix==5){
          do{affTab(recettes);
            Terminal.ecrireStringln("Quelle recette ?");
            indiceR=Terminal.lireInt();
          }while(verifError(indiceR,recettes)==1);
          Terminal.sautDeLigne();
          Terminal.ecrireStringln("La note de "+ recettes[indiceR]+" est "+ moynotes[indiceR]);
          Terminal.sautDeLigne();
        }
        if (choix==6){
          recettes=addcase(recettes);
          moynotes=addcase(moynotes);
          nbvotant=addcase(nbvotant);
          totalnotes=addcase(totalnotes);
        }
        if (choix==7){
          do{
            affTab(recettes);
            Terminal.ecrireStringln("Quelle recette ?");
            indiceR=Terminal.lireInt();
          }while(verifError(indiceR,recettes)==1);
          recettes=removecase(indiceR,recettes);
          moynotes=removecase(indiceR,moynotes);
          nbvotant=removecase(indiceR,nbvotant);
          totalnotes=removecase(indiceR,totalnotes);
        }
        
      } while (choix!=menu.length-1);
      
      
      Terminal.sautDeLigne();
      Terminal.ecrireStringln("Le programme est terminé. Merci de votre participation.");
      
    }
    
    
    
    
    
    
    //******* METHODES : INTERVENTIONS SUR TABLEAUX ********
    
    //Copier un tableau
    public static String[] copieTab(String tab[]){
      String[] tab2=new String[tab.length];
      for(int i=0;i<tab.length;i++){
        String x;
        x=tab[i];
        tab2[i]=x;
      }
      return tab2;
    }
    
    public static double[] copieTab(double tab[]){
      double[] tab2=new double[tab.length];
      for(int i=0;i<tab.length;i++){
        double x;
        x=tab[i];
        tab2[i]=x;
      }
      return tab2;
    }
    
    //Ajouter une case à un tableau
    public static String[] addcase(String tab[]){
      String[] temp=new String[tab.length+1];
      for(int i=0; i<tab.length;i++){
        temp[i]=tab[i];
      }
      tab=temp;
      Terminal.ecrireString("Entrer le nom de la nouvelle recette");
      tab[tab.length-1]=Terminal.lireString();
      return tab;
    }
    
    public static double[] addcase(double tab[]){
      double[] temp=new double[tab.length+1];
      for(int i=0; i<tab.length;i++){
        temp[i]=tab[i];
      }
      tab=temp;
      return tab;
    }
    
    //Supprimer une case d'un tableau
    public static String[] removecase(int choix, String tab[]){
      String[] temp=new String[tab.length-1];
      for (int i=choix; i<tab.length-1; i++){ 
        tab[i]=tab[i+1];         
      }
      for (int i=0; i<temp.length; i++){ 
        temp[i]=tab[i];        
      }
      tab=temp;
      return tab;
    }
    public static double[] removecase(int choix, double tab[]){
      double[] temp=new double[tab.length-1];
      for (int i=choix; i<tab.length-1; i++){ 
        tab[i]=tab[i+1];         
      }
      for (int i=0; i<temp.length; i++){ 
        temp[i]=tab[i];        
      }
      tab=temp;
      return tab;
    }
    
    
    
    //******* METHODES D'AFFICHAGE ********
    
    //affichage d'un tableau de String
    public static void affTab(String tab[]){
      for(int i=1;i<tab.length;i++){
        Terminal.ecrireStringln(i+" "+tab[i]);
      }
      Terminal.sautDeLigne();
    }
    
    //affichage d'un tableau de Int
    public static void affTab(int tab[]){
      for(int i=0;i<tab.length;i++){
        Terminal.ecrireString(tab[i]+"|");
      }
      Terminal.sautDeLigne();
    }
    
    //affichage d'un tableau de double
    public static void affTab(double tab[]){
      for(int i=0;i<tab.length;i++){
        Terminal.ecrireString(tab[i]+"|");
      }
      Terminal.sautDeLigne();
    }
    
    //affichage de 3 tableaux
    public static void afftab3(String tab1[],double tab2[],double tab3[]){
      for (int i=1; i<tab1.length; i++){
        Terminal.ecrireStringln(i+ " "+tab1[i]+": \t " + tab2[i]+" (" + Math.round(tab3[i]) +" votes)");
      }
      Terminal.sautDeLigne();
    }
    
      //affichage des recettes par notes croissantes
    public static void trieTabs1(String str[], double tab[], double tab2[], double tab3[]){
      double min=0.0,valeurTrie, valeurTrie1, valeurTrie2;
      int indiceMin=0;    
      String trieStr; 
      
      for(int j=0; j<tab.length-1;j++){
        for(int i=j; i<tab.length-1;i++){
          if(tab[indiceMin]<=tab[i+1]){
            indiceMin=indiceMin;
            min=tab[indiceMin];
          }else{
            indiceMin=i+1;
            min=tab[i+1];
          }
        }
        valeurTrie=tab[j];
        tab[j]=tab[indiceMin];
        tab[indiceMin]=valeurTrie;
        
        valeurTrie1=tab2[j];
        tab2[j]=tab2[indiceMin];
        tab2[indiceMin]=valeurTrie1;
        
        valeurTrie2=tab3[j];
        tab3[j]=tab3[indiceMin];
        tab3[indiceMin]=valeurTrie2;
        
        trieStr=str[j];
        str[j]=str[indiceMin];
        str[indiceMin]=trieStr;
        
        indiceMin=j+1;
        min=tab[j+1];
      }
      
    }
    
    //affichage des recettes par notes décroissantes
    public static void trieTabs2(String str[], double tab[], double tab2[], double tab3[]){
      double max=0.0,valeurTrie, valeurTrie1, valeurTrie2;
      int indiceMax=1;    
      String trieStr; 
      
      for(int j=1; j<tab.length-1;j++){
        for(int i=j-1; i<tab.length-1;i++){
          if(tab[indiceMax]>=tab[i+1]){
            indiceMax=indiceMax;
            max=tab[indiceMax];
          }else{
            indiceMax=i+1;
            max=tab[i+1];
          }
          
        }    
        valeurTrie=tab[j];
        tab[j]=tab[indiceMax];
        tab[indiceMax]=valeurTrie;
        
        trieStr=str[j];
        str[j]=str[indiceMax];
        str[indiceMax]=trieStr;
        
        valeurTrie1=tab2[j];
        tab2[j]=tab2[indiceMax];
        tab2[indiceMax]=valeurTrie1;
        
        valeurTrie2=tab3[j];
        tab3[j]=tab3[indiceMax];
        tab3[indiceMax]=valeurTrie2;
        
        indiceMax=j+1;
        max=tab[indiceMax];
      }
      
    }
    
    
    //******* METHODES : GESTION DES ERREURS ********
    
    //verif error recettes
    public static int verifError(int choix, String tab[]){
      int res;
      if (choix<=0 || choix>tab.length-1){
        msg(401,tab);
        res=1;
      }else{
        res=2;
      }return res;
    }
    //verif error étoiles
    public static int verifError(double choix){
      int res;
      String[] tab = new String [9];
      if (choix<=0 || choix>5){
        msg(402,tab);
        res=1;
      }else{
        res=2;
      }return res;
    }
    
    //Messages d'erreur
    public static void msg(int x, String tab[]){
      if(x==401){
        Terminal.sautDeLigne();  
        Terminal.ecrireStringln("***Attention***\nCe choix n'est pas valide.\nFaites votre choix entre 1 et "+(tab.length-1)+".");
        Terminal.sautDeLigne();
      }else{
        Terminal.sautDeLigne();  
        Terminal.ecrireStringln("***Attention***\nCe choix n'est pas valide.\nFaites votre choix entre 1 et 5 étoiles.");
        Terminal.sautDeLigne();
        
      }
    }
    
    
    
    
  }