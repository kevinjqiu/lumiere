(ns lumiere)

(def RESET "\033[0m")

(defrecord Luminere [text fg bg styles]
  Object
  (toString [this]
    (str (format "%s%s%s" (:styles this) (:text this) RESET))))

(defmacro defstyle [style-name
                    style-func-name
                    ^Integer style-code]
  `(do
     (def ~style-name (format "\033[%dm" ~style-code))
     (defn ~style-func-name [text#]
       (cond (instance? String text#) (Luminere. text# nil nil ~style-name)
             (instance? Luminere text#) (assoc text# :styles ~style-name)
             :else (throw (java.lang.IllegalArgumentException.))))))

(defstyle BOLD bold 1)
(defstyle ITALIC italic 3)
(defstyle UNDERLINE underline 4)

(defn- colour 
  ([^Integer code ^Boolean is-bg?]
   (format "\033[%dm" (+ (if is-bg? 40 30) code)))
  ([^Integer code]
   (colour code false)))

(defmacro defcolour [colour-name
                     bg-colour-name
                     colour-func-name
                     bg-colour-func-name
                     ^Integer colour-code]
  `(do
     (def ~colour-name (colour ~colour-code))
     (def ~bg-colour-name (colour ~colour-code true))
     (defn ~colour-func-name [text#]
       (format "%s%s%s" ~colour-name text# RESET))
     (defn ~bg-colour-func-name [text#]
       (format "%s%s%s" ~bg-colour-name text# RESET))))

(defcolour BLACK BG-BLACK black bg-black 0)
(defcolour RED BG-RED red bg-red 1)
(defcolour GREEN BG-GREEN green bg-green 2)
(defcolour YELLOW BG-YELLOW yellow bg-yellow 3)
(defcolour BLUE BG-BLUE blue bg-blue 4)
(defcolour MAGENTA BG-MAGENTA magenta bg-magenta 5)
(defcolour CYAN BG-CYAN cyan bg-cyan 6)
(defcolour WHITE BG-WHITE white bg-white 7)
(defcolour DEFAULT BG-DEFAULT default bg-default 9)
