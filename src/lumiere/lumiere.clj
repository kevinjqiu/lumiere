(ns lumiere.lumiere
  (:use [clojure.string :only [join]]))

(def RESET "\033[0m")

(defn- ansi-escape-seq [& codes]
  (format "\033[%sm" (join ";" (filter #(not= % nil) codes))))

(defrecord Lumiere [text fg bg styles]
  Object
  (toString [this]
    (let [prefix (ansi-escape-seq (:fg this) (:bg this) (:styles this))]
      (format "%s%s%s" prefix (:text this) RESET))))

(defn- adapt-lum [text option value]
  (let [local-option-map (merge {:fg nil :bg nil :styles nil} {option value})]
    (cond
      (instance? String text) (Lumiere. text (:fg local-option-map) (:bg local-option-map) (:styles local-option-map))
      (instance? Lumiere text) (assoc text option value)
      :else (throw (java.lang.IllegalArgumentException.)))))

(defmacro defstyle [style-func-name ^Integer style-code]
  `(defn ~style-func-name [text#]
       (adapt-lum text# :styles ~style-code)))

(defstyle bold 1)
(defstyle italic 3)
(defstyle underline 4)

(defn- colour 
  ([^Integer code ^Boolean is-bg?]
   (+ (if is-bg? 40 30) code))
  ([^Integer code]
   (colour code false)))

(defmacro defcolour [colour-func-name bg-colour-func-name ^Integer colour-code]
  `(do
     (defn ~colour-func-name [text#]
       (adapt-lum text# :fg (colour ~colour-code)))
     (defn ~bg-colour-func-name [text#]
       (adapt-lum text# :bg (colour ~colour-code true)))))

(defcolour black bg-black 0)
(defcolour red bg-red 1)
(defcolour green bg-green 2)
(defcolour yellow bg-yellow 3)
(defcolour blue bg-blue 4)
(defcolour magenta bg-magenta 5)
(defcolour cyan bg-cyan 6)
(defcolour white bg-white 7)
(defcolour default bg-default 9)
