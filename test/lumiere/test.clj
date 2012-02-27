(ns lumiere.test
  (:use [lumiere])
  (:use [clojure.test]))

(deftest test-only-foreground
  (is (= "\033[30msome black text\033[0m" (black "some black text")))
  (is (= "\033[31msome red text\033[0m" (red "some red text")))
  (is (= "\033[32msome green text\033[0m" (green "some green text")))
  (is (= "\033[33msome yellow text\033[0m" (yellow "some yellow text")))
  (is (= "\033[34msome blue text\033[0m" (blue "some blue text")))
  (is (= "\033[35msome magenta text\033[0m" (magenta "some magenta text")))
  (is (= "\033[36msome cyan text\033[0m" (cyan "some cyan text")))
  (is (= "\033[37msome white text\033[0m" (white "some white text")))
  (is (= "\033[39msome default text\033[0m" (default "some default text"))))

(deftest test-only-background
  (is (= "\033[40msome black text\033[0m" (bg-black "some black text")))
  (is (= "\033[41msome red text\033[0m" (bg-red "some red text")))
  (is (= "\033[42msome green text\033[0m" (bg-green "some green text")))
  (is (= "\033[43msome yellow text\033[0m" (bg-yellow "some yellow text")))
  (is (= "\033[44msome blue text\033[0m" (bg-blue "some blue text")))
  (is (= "\033[45msome magenta text\033[0m" (bg-magenta "some magenta text")))
  (is (= "\033[46msome cyan text\033[0m" (bg-cyan "some cyan text")))
  (is (= "\033[47msome white text\033[0m" (bg-white "some white text")))
  (is (= "\033[49msome default text\033[0m" (bg-default "some default text"))))

(deftest test-style
  (is (= "\033[1msome bold text\033[0m" (bold "some bold text")))
  (is (= "\033[3msome italic text\033[0m" (italic "some italic text")))
  (is (= "\033[4msome underline text\033[0m" (underline "some underline text"))))
