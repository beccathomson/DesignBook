
package chapter1;

/* exercises:
 * iterative --> what is the impact on design?
 * choose to display 3rd vs third. if user includes argument "digit", use digits
 * impact on quality attributes of the design?
 */




public class TwelveDaysBecca
{
    public static void main(String[] args)
    {
        if (args.length > 0 && args[0].equalsIgnoreCase("digit")){
            System.out.println(poem(DAYS_DIGIT));
        } else {
            System.out.println(poem());
        }
    }

    static String[] DAYS = {"first", "second", "third", "fourth",
            "fifth", "sixth", "seventh", "eighth",
            "ninth", "tenth", "eleventh", "twelfth"};

    static String[] DAYS_DIGIT = {"1st", "2nd", "3rd", "4th", "5th", "6th",
            "7th", "8th", "9th", "10th", "11th", "12th"};

    static String[] GIFTS = {
            "a partridge in a pear tree",
            "two turtle doves",
            "three French Hens",
            "four Calling Birds",
            "five Golden Rings",
            "six Geese a Laying",
            "seven Swans a Swimming",
            "eight Maids a Milking",
            "nine Ladies Dancing",
            "ten Lords a Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming"
    };

    /*
     * Returns the first line in the verse for a given day.
     */
    static String firstLine(int day)
    {
        return "On the " + DAYS[day] +
                " day of Christmas my true love sent to me:\n";
    }

    static String firstLine(int day, String[] day_format)
    {
        return "On the " + day_format[day] +
                " day of Christmas my true love sent to me:\n";
    }

    /*
     * Returns a string that lists all the gifts received on a given
     * day.
     */

    // here we replace recursion with iteration
    static String allGifts(int day)
    {
        String gifts = "";
        for (; day > 0; day--) {
            gifts += GIFTS[day] +"\n";
        }
        return gifts + "and " + GIFTS[0];
    }


    static String poem(String[] day_format)
    {
        StringBuilder poem = new StringBuilder(firstLine(0, day_format) + GIFTS[0] + "\n\n");
        for( int day = 0; day < 12; day++ )
        {
            poem.append(firstLine(day, day_format)).append(allGifts(day)).append("\n\n");
        }
        return poem.toString();
    }
    /*
     * Returns the text of the entire poem.
     */
    static String poem()
    {
        StringBuilder poem = new StringBuilder(firstLine(0) + GIFTS[0] + "\n\n");
        for( int day = 0; day < 12; day++ )
        {
            poem.append(firstLine(day)).append(allGifts(day)).append("\n\n");
        }
        return poem.toString();
    }
}
