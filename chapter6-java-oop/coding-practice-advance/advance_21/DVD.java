package advance_21;

public class DVD extends Item{
    private final String dvdName;
    private final String dvdOwnerCompany;

    public DVD(String dvdName, String dvdOwnerCompany) {
        this.dvdName = dvdName;
        this.dvdOwnerCompany = dvdOwnerCompany;
    }

    @Override
    public void displayDetails() {
        System.out.println("DVD Details");
        System.out.println("DVD Name = " + dvdName);
        System.out.println("DVD Owner Company Name = " + dvdOwnerCompany);
        System.out.println();
    }
}
