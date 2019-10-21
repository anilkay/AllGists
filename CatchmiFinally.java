
 class CatchmiFinally {
    public UseCommonText() {
    }

    public static void main(String[] args) {
        System.out.println(exceptionNotShown());
    }
      public  static String exceptionNotShown(){
        try {
            throw new IllegalArgumentException();//Can't catch or use exceptions.
        }
        catch (IllegalArgumentException iax){
            System.err.println(iax); //İllegal argumant exception catched
            return "catch dönüyor bakalım."; 
        }
        finally {
            return "finally dönüyor";
        }

    }
  
}
