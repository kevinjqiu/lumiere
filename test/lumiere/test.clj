(ns lumiere.test
  (:use [lumiere])
  (:use [clojure.test]))

(deftest test-only-foreground
  (is (= "\033[30msome black text\033[0m" (str (black "some black text"))))
  (is (= "\033[31msome red text\033[0m" (str (red "some red text"))))
  (is (= "\033[32msome green text\033[0m" (str (green "some green text"))))
  (is (= "\033[33msome yellow text\033[0m" (str (yellow "some yellow text"))))
  (is (= "\033[34msome blue text\033[0m" (str (blue "some blue text"))))
  (is (= "\033[35msome magenta text\033[0m" (str (magenta "some magenta text"))))
  (is (= "\033[36msome cyan text\033[0m" (str (cyan "some cyan text"))))
  (is (= "\033[37msome white text\033[0m" (str (white "some white text"))))
  (is (= "\033[39msome default text\033[0m" (str (default "some default text")))))

(deftest test-only-background
  (is (= "\033[40msome black text\033[0m" (str (bg-black "some black text"))))
  (is (= "\033[41msome red text\033[0m" (str (bg-red "some red text"))))
  (is (= "\033[42msome green text\033[0m" (str (bg-green "some green text"))))
  (is (= "\033[43msome yellow text\033[0m" (str (bg-yellow "some yellow text"))))
  (is (= "\033[44msome blue text\033[0m" (str (bg-blue "some blue text"))))
  (is (= "\033[45msome magenta text\033[0m" (str (bg-magenta "some magenta text"))))
  (is (= "\033[46msome cyan text\033[0m" (str (bg-cyan "some cyan text"))))
  (is (= "\033[47msome white text\033[0m" (str (bg-white "some white text"))))
  (is (= "\033[49msome default text\033[0m" (str (bg-default "some default text")))))

(deftest test-style
  (is (= "\033[1msome bold text\033[0m" (str (bold "some bold text"))))
  (is (= "\033[3msome italic text\033[0m" (str (italic "some italic text"))))
  (is (= "\033[4msome underline text\033[0m" (str (underline "some underline text")))))

(deftest test-fg-bg-with-style-roundtrip
  (is (= (str (bold (red "red and bold"))) (str (red (bold "red and bold"))))))
