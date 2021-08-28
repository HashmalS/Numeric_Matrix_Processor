class Util {
    public static int indexOf(String src, String tgt) {
        if (src.length() < tgt.length()) {
            return -1;
        } else if (src.startsWith(tgt)) {
            return 0;
        } else {
            int index = indexOf(src.substring(1), tgt);
            return (index == -1) ? -1 : index + 1;
        }
    }
}