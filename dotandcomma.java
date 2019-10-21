public class dotandcomma{
      double floting=0;
        try {
            floting = reader.nextDouble();
        }
        catch (InputMismatchException mismatch){
            reader.useLocale(Locale.ENGLISH);
            floting=reader.nextDouble();
        }
        System.out.println("Double value: "+floting);
}