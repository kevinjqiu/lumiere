(ns lumiere.test
  (:use [lumiere])
  (:use [clojure.test]))

(deftest test-only-foreground
  (is (= "\033[1;30msome black text\033[0m" (black "some black text")))
  (is (= "\033[1;31msome red text\033[0m" (red "some red text")))
  (is (= "\033[1;32msome green text\033[0m" (green "some green text")))
  (is (= "\033[1;33msome yellow text\033[0m" (yellow "some yellow text")))
  (is (= "\033[1;34msome blue text\033[0m" (blue "some blue text")))
  (is (= "\033[1;35msome magenta text\033[0m" (magenta "some magenta text")))
  (is (= "\033[1;36msome cyan text\033[0m" (cyan "some cyan text")))
  (is (= "\033[1;37msome white text\033[0m" (white "some white text"))))
