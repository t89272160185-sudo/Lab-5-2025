import functions.FunctionPoint;
import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;

public class Main {
    public static void main(String[] args) {
        FunctionPoint[] source = {
                new FunctionPoint(0.0, 0.0),
                new FunctionPoint(1.0, 1.0),
                new FunctionPoint(2.0, 4.0)
        };

        ArrayTabulatedFunction arrayFunction = new ArrayTabulatedFunction(source);
        LinkedListTabulatedFunction listFunction = new LinkedListTabulatedFunction(source);

        System.out.println("=== toString() ===");
        System.out.println("Array:      " + arrayFunction);
        System.out.println("LinkedList: " + listFunction);

        System.out.println("\n=== equals() across implementations ===");
        TabulatedFunction sameArray = new ArrayTabulatedFunction(source);
        TabulatedFunction arrayTab = arrayFunction;
        TabulatedFunction listTab = listFunction;
        System.out.println("Array vs LinkedList: " + arrayTab.equals(listTab));
        System.out.println("LinkedList vs Array: " + listTab.equals(arrayTab));
        System.out.println("Array vs new Array:  " + arrayTab.equals(sameArray));

        System.out.println("\n=== hashCode() consistency ===");
        System.out.println("Array hash:      " + arrayFunction.hashCode());
        System.out.println("LinkedList hash: " + listFunction.hashCode());
        TabulatedFunction tweaked = arrayFunction.clone();
        tweaked.setPointY(1, tweaked.getPointY(1) + 0.003);
        System.out.println("Tweaked hash (+0.003 to y1): " + tweaked.hashCode());

        System.out.println("\n=== clone() deep copy ===");
        ArrayTabulatedFunction arrayClone = arrayFunction.clone();
        LinkedListTabulatedFunction listClone = listFunction.clone();
        arrayFunction.setPointY(0, 10.0);
        listFunction.setPointY(2, 8.0);
        System.out.println("Original array after change: " + arrayFunction);
        System.out.println("Array clone preserved:       " + arrayClone);
        System.out.println("Original list after change:  " + listFunction);
        System.out.println("List clone preserved:        " + listClone);
        System.out.println("Clone equality check:");
        System.out.println("- arrayClone equals tweaked:     " + arrayClone.equals(tweaked));
        System.out.println("- listClone equals original list:" + listClone.equals(listFunction));
    }
}
