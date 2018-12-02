package stringfunctions;

import java.util.Arrays;

public class StringFunctions {
  private static int count(String s, String target) {
    int count = 0;
    int n = target.length();

    for(int i = 0; i <= s.length() - n; i++) {
      String piece = s.substring(i, i + n);

      if(piece.equals(target)) {
        count++;
      }
    }

    return count;
  }

  private static int countIgnoreCase(String s, String target) {
    String sUpperCase = s.toUpperCase();
    String targetUpperCase = target.toUpperCase();

    return count(sUpperCase, targetUpperCase);
  }

  private static int count2(String s, String target) {
    int count = 0;
    int n = target.length();
    int i = 0;

    while(i <= s.length() - n) {
      int index = s.indexOf(target, i);

      if(index >= 0) {
        count++;
      }

      i = index + 1;
    }

    return count;
  }

  private static String acronym(String phrase) {
    StringBuilder result = new StringBuilder();

    for(String token : phrase.split("\\s+")) {
      result.append(token.toUpperCase().charAt(0));
    }

    return result.toString();
  }

  private static String acronym2(String phrase) {
    StringBuilder result = new StringBuilder();
    String[] words = phrase.split("\\s+");

    for(int i = 0; i < words.length; i++) {
      String token = words[i];
      char firstCharacter = token.toUpperCase().charAt(0);

      result.append(firstCharacter);
    }

    return result.toString();
  }

  private static int countWord(String s, String target) {
    int count = 0;
    String[] words = s.split("\\s+");

    for(String word : words) {
      if(word.equals(target)) {
        count += 1;
      }
    }

    return count;
  }

  private static int countWordIgnoreCase(String s, String target) {
    int count = 0;
    String[] words = s.split("\\s+");

    for(String word : words) {
      if(word.equalsIgnoreCase(target)) {
        count += 1;
      }
    }

    return count;
  }

  private static String reverse(String s) {
    StringBuilder builder = new StringBuilder();

    for(int i = s.length() - 1; i >= 0; i--) {
      builder.append(s.charAt(i));
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    int count = count2("this and this and that and this", "this");

    System.out.println("Number of this's: " + count);


    System.out.println(acronym("The super Rik  Yay"));
    System.out.println(acronym2("The super Rik  Yay"));
    System.out.println(countWord("cat dog cat dog cat", "cat"));
    System.out.println(countWordIgnoreCase("caT dog cAt dog Cat", "cAt"));
    System.out.println("Reverse of \"abc\" = \"" + reverse("abc") + "\"");
    System.out.println("Reverse of \"\" = \"" + reverse("") + "\"");

    System.out.println("\n");

    Arrays.asList("This sentence has long gaps.".split("\\s+")).forEach(x -> System.out.println("\"" + x + "\""));
    System.out.println();

    Arrays.asList("What about punctuation?".split("\\s+")).forEach(x -> System.out.println("\"" + x + "\""));
    System.out.println();

    Arrays.asList("This is a sentence.".split("\\s")).forEach(x -> System.out.println("\"" + x + "\""));
    System.out.println();

    Arrays.asList("This is a sentence.".split("s")).forEach(x -> System.out.println("\"" + x + "\""));
    System.out.println();

    Arrays.asList("This is a sentence.".split("e")).forEach(x -> System.out.println("\"" + x + "\""));
    System.out.println();
  }
}
