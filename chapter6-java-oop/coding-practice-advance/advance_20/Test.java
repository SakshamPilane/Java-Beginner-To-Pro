package advance_20;

public class Test {
    public static void main(String[] args) {
        Notification notifyObj;

        System.out.println("Overridden by SMSNotification Class");
        notifyObj = new SMSNotification();
        notifyObj.send();
        System.out.println();

        System.out.println("Overridden by EmailNotification Class");
        notifyObj = new EmailNotification();
        notifyObj.send();
        System.out.println();

        System.out.println("Overridden by PushNotification Class");
        notifyObj = new PushNotification();
        notifyObj.send();
        System.out.println();
    }
}
