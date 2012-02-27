(ns lumiere)

(defn- colour 
  ([code is-bg?]
   (format "\033[1;%dm" (+ (if is-bg? 40 30) code)))
  ([code]
   (colour code false)))

(defmacro defcolour [colour-name bg-colour-name colour-func-name bg-colour-func-name colour-code]
  `(do
     (def ~colour-name (colour ~colour-code))
     (def ~bg-colour-name (colour ~colour-code true))
     (defn ~colour-func-name [text#] (format "%s%s%s" ~colour-name text# RESET))
     (defn ~bg-colour-func-name [text#] (format "%s%s%s" ~bg-colour-name text# RESET))))

(def RESET "\033[0m")
(def BOLD "\033[1m")
(def ITALIC "\033[3m")
(def UNDERLINE "\033[4m")

(defcolour BLACK BG-BLACK black bg-black 0)
(defcolour RED BG-RED red bg-red 1)
(defcolour GREEN BG-GREEN green bg-green 2)
(defcolour YELLOW BG-YELLOW yellow bg-yellow 3)
(defcolour BLUE BG-BLUE blue bg-blue 4)
(defcolour MAGENTA BG-MAGENTA magenta bg-magenta 5)
(defcolour CYAN BG-CYAN cyan bg-cyan 6)
(defcolour WHITE BG-WHITE white bg-white 7)
(defcolour DEFAULT BG-DEFAULT default bg-default 9)
