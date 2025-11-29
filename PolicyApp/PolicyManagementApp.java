import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PolicyManagementApp {

    public static double calculateFutureValue(double investmentAmount, int years) {
        return investmentAmount * Math.pow((1 + 0.08), years);
    }

    public static void findHighValuePolicy(List<PolicyHolder> list) {
        System.out.println("------ High Value Policy Holders (Investment > 1,00,000) ------");
        for (PolicyHolder ph : list) {
            if (ph.getInvestAmount() > 100000) {
                System.out.println("Policy ID: " + ph.getPolicyId() +
                        ", Name: " + ph.getName() +
                        ", Investment: " + ph.getInvestAmount() +
                        ", Years In Force: " + ph.getYearsInForce());
            }
        }
    }

    public static PolicyHolder searchPolicy(List<PolicyHolder> list, String id) {
        for (PolicyHolder ph : list) {
            if (ph.getPolicyId().equalsIgnoreCase(id)) {
                return ph;
            }
        }
        return null;
    }

    public static void deletePolicy(List<PolicyHolder> list, String id) {
        PolicyHolder found = searchPolicy(list, id);
        if (found != null) {
            list.remove(found);
            System.out.println("Policy Removed Successfully!");
        } else {
            System.out.println("Policy Not Found!");
        }
    }

    public static void updatePolicy(List<PolicyHolder> list, String id, Scanner sc) {
        PolicyHolder found = searchPolicy(list, id);

        if (found != null) {
            sc.nextLine();
            System.out.print("Enter New Name: ");
            found.setName(sc.nextLine());
            System.out.print("Enter New Amount: ");
            found.setInvestAmount(sc.nextDouble());
            System.out.print("Enter New Years: ");
            found.setYearsInForce(sc.nextInt());

            System.out.println("Policy Updated Successfully!");
        } else {
            System.out.println("Policy Not Found!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<PolicyHolder> policyList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n======= Policy Holder Management System =======");
            System.out.println("1. Add Policy Holder");
            System.out.println("2. Display All Policies");
            System.out.println("3. Find High Value Policies");
            System.out.println("4. Calculate Future Value");
            System.out.println("5. Search Policy by ID");
            System.out.println("6. Update Policy");
            System.out.println("7. Delete Policy");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Policy ID: ");
                    String id = sc.next();

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Investment Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Enter Years In Force: ");
                    int years = sc.nextInt();

                    policyList.add(new PolicyHolder(id, name, amount, years));
                    System.out.println("Policy Added Successfully!");
                    break;

                case 2:
                    System.out.println("--------- All Policies ---------");
                    for (PolicyHolder ph : policyList) {
                        System.out.println("ID: " + ph.getPolicyId() +
                                ", Name: " + ph.getName() +
                                ", Amount: " + ph.getInvestAmount() +
                                ", Years: " + ph.getYearsInForce());
                    }
                    break;

                case 3:
                    findHighValuePolicy(policyList);
                    break;

                case 4:
                    System.out.print("Enter Investment Amount: ");
                    double inv = sc.nextDouble();
                    System.out.print("Enter Years: ");
                    int yr = sc.nextInt();
                    System.out.println("Future Value = " + calculateFutureValue(inv, yr));
                    break;

                case 5:
                    System.out.print("Enter Policy ID to Search: ");
                    String sid = sc.next();
                    PolicyHolder search = searchPolicy(policyList, sid);
                    if (search != null) {
                        System.out.println("Policy Found -> ID: " + search.getPolicyId() +
                                ", Name: " + search.getName() +
                                ", Amount: " + search.getInvestAmount() +
                                ", Years: " + search.getYearsInForce());
                    } else {
                        System.out.println("Policy Not Found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter Policy ID to Update: ");
                    updatePolicy(policyList, sc.next(), sc);
                    break;

                case 7:
                    System.out.print("Enter Policy ID to Delete: ");
                    deletePolicy(policyList, sc.next());
                    break;

                case 8:
                    System.out.println("Exiting Application... Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
