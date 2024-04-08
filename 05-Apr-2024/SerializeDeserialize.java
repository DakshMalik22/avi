package javaBasics.date_05_04_24;

class SerializeDeserialize {

    // Serialize an array of strings
    static String serialize(String[] strings) {
        StringBuilder serialized = new StringBuilder();
        for (String str : strings) {
            int len = str.length();
            serialized.append(str).append(len).append("~");
        }
        return serialized.toString();
    }

    // Deserialize a serialized string into an array of strings
    static void deserialize(String serialized, String[] deserialized) {
        int len = 0, pos = 0;
        String temp = "";
        int i = 0;
        while (pos > -1) {
            pos = serialized.indexOf("~", pos + 1);
            if (pos > 0) {
                len = serialized.charAt(pos - 1) - '0';
                temp = serialized.substring(pos + 1, pos + len + 1);
                deserialized[i++] = temp;
                temp = "";
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = {"scaler", "academy"};

        String serializedString = serialize(strings);
        System.out.println("Serialized string: " + serializedString);

        // Initialize an array to store deserialized strings
        String[] deserializedStrings = new String[strings.length];
        deserialize(serializedString, deserializedStrings);

        // Print the deserialized strings
        System.out.println("Deserialized strings:");
        for (String str : deserializedStrings) {
            System.out.println(str);
        }
    }
}
