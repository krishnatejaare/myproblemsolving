package datastructures;

import com.sun.deploy.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TEST {
        private static class Pair {
            private int start;
            private int end;

            public Pair(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
        protected static List<String> parseSQLOutput(String output) {
            List<String> rows = new ArrayList<>();
            // Get first line by breaking on \n. We can guarantee
            // that \n marks the end of the first line, but not for
            // subsequent lines (as it could be in the cells)
            String firstLine = output.split("\n", 2)[0];
            // at least 4 lines, even for empty sql output
            //    +---+---+
            //    |  a|  b|
            //    +---+---+
            //    +---+---+

            // use the first line to determine the position of each cell
            String[] tokens = StringUtils.splitString(firstLine, "\\+");
            // pairs keeps the start/end position of each cell. We parse it from the first row
            // which use '+' as separator
            List<Pair> pairs = new ArrayList<>();
            int start = 0;
            int end = 0;
            for (String token : tokens) {
                start = end + 1;
                end = start + token.length();
                pairs.add(new Pair(start, end));
            }

            // Use the header line to determine the position
            // of subsequent lines
            int lineStart = 0;
            int lineEnd = firstLine.length();
            while (lineEnd < output.length()) {
                // Only match format "|....|"
                // skip line like "+---+---+" and "only showing top 1 row"
                String line = output.substring(lineStart, lineEnd);
                // Use the DOTALL regex mode to match newlines
                if (line.matches("(?s)^\\|.*\\|$")) {
                    List<String> cells = new ArrayList<>();
                    for (Pair pair : pairs) {
                        // strip the blank space around the cell and escape the string

                    }
                    rows.add(StringUtils.join(cells, "\t"));
                }
                // Determine position of next line skipping newline
                lineStart += firstLine.length() + 1;
                lineEnd = lineStart + firstLine.length();
            }
            return rows;
        }

    public static String convertToBinary(String input, String encoding)
            throws UnsupportedEncodingException {
        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();
        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e ^ 255))
                .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }

    public static String deal(String s) {
        StringBuffer sb = new StringBuffer(s);
        StringBuffer se = new StringBuffer();
        int l = sb.length();
        char c;
        for (int i = 0; i < l; i++) {
            c = sb.charAt(i);
            if (Character.UnicodeScript.of(c) != Character.UnicodeScript.HAN) {
                se.append(c);
            }
        }
        return new String(se);
    }

        public static void main(String[]args){
            String s="%text +----------+----------------------------------+----------------------------------------+--------+----------+-------------+-------------+--------------+-----------+------------+---------------+---------------------------------------------------------------------------------------------------------------------+---------------+---------+------+-------------+------------+------------------------------------+---------------------------------------------------------------------+-----------------------------+----------------------+----------------------------+-----------------------+-----------+----------------------+---------------------+----------------+--------------------+----------+\n" +
                    "|EVENT_DATE|IREPORTER_ID                      |DEVICE_UDID                             |PLATFORM|OS_VERSION|BUILD_VERSION|DEVICE_FAMILY|DEVICE_VERSION|DEVICE_CODE|BROWSER_NAME|BROWSER_VERSION|CLIENT_INFO                                                                                                          |IP_COUNTRY_CODE|IP_CITY  |IP_ASN|IP_DOMAIN    |EVENT_SOURCE|COMMAND_ID                          |DISPLAY_MESSAGE_TEXT                                                 |EVENT_STAGE                  |RESPONSE_TIME_EPOCH_MS|APNS_ROUNDTRIP_TIME_EPOCH_MS|EVENT_DURATION_EPOCH_MS|STATUS_CODE|LOCK_WITH_NEW_PASSCODE|ACTION_TRIGGER_REASON|PROTOCOL_VERSION|COUNT_OF_OCCURRENCES|date      |\n" +
                    "+----------+----------------------------------+----------------------------------------+--------+----------+-------------+-------------+--------------+-----------+------------+---------------+---------------------------------------------------------------------------------------------------------------------+---------------+---------+------+-------------+------------+------------------------------------+---------------------------------------------------------------------+-----------------------------+----------------------+----------------------------+-----------------------+-----------+----------------------+---------------------+----------------+--------------------+----------+\n" +
                    "|2019-07-16|27701496c276e6681308422be84cf8a200|66488beefeffa6826bf1abee30dca9ca927b92ec|ios     |12.3.1    |unknown_na   |iphone       |unknown_na    |iPhone9,1  |ie          |6.0            |Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727) UA     |la             |vientiane|9873  |unknown_na   |client      |c8e9c48d-e225-46e0-86ac-10ca964003f1|逾期提示进快处理你的还款加QQ2026485305或与App客服联系手机恢复正常使用|commandqueuedlockmessagetrack|null                  |null                        |unknown_na             |unknown_na |YES                   |unknown_na           |unknown_na      |1                   |2019-07-16|\n" +
                    "|2019-07-16|d24868be3d8fe98a489bf8c34426ba1000|7d73889188cf59eb676c8a1269100b0e2543a32e|ios     |12.1.4    |unknown_na   |iphone       |unknown_na    |iPhone7,1  |chrome      |75.0           |Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36 UA|us             |muskogee |7018  |sbcglobal.net|client      |c1c54d05-a67a-48e0-a7f7-b0ee872bf122| (918) 822-4508     |commandqueuedlockmessagetrack|null                  |null                        |unknown_na             |unknown_na |NO                    |unknown_na           |unknown_na      |1                   |2019-07-16|\n" +
                    "+----------+----------------------------------+----------------------------------------+--------+----------+-------------+-------------+--------------+-----------+------------+---------------+---------------------------------------------------------------------------------------------------------------------+---------------+---------+------+-------------+------------+------------------------------------+---------------------------------------------------------------------+-----------------------------+----------------------+----------------------------+-----------------------+-----------+----------------------+---------------------+----------------+--------------------+----------+";
            String input = "逾期提示进快处理你的还款加QQ2026485305或与App客服联系手机恢复正常使用";
            System.out.println(input);
            System.out.println(deal(input));
            System.out.println(deal(" "));
            System.out.println(deal(s));

            String original = "\u304B\u304C\u3068";



            }
        }




