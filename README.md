# Lumiere

Lumiere is a [Clojure](http://clojure.org) library that allows you to output stylized text to the terminal using ANSI escape sequences.

## Usage

Use [leiningen](https://github.com/technomancy/leiningen),

```clojure
(defproject your-project "1.0"
  :dependencies [[lumiere "1.0.0-SNAPSHOT"]])
```

Lumiere has a very simple API. To use it, simple `use` or `require` it in your namespace:

```clojure
(ns your-namespace
  (:refer [lumiere :refer :all]))
```

and start decorating your text:

```clojure
(print (str (red "Are you sure you want to quit? [Y/n]")))
(print (str (green "Continue")))
(print (str (bold (green "Have a nice day!"))))
(-> "Stop right there" red bold underline str print)
```

* Available colours (functions) are:
  * `black`, `bg-black`
  * `red`, `bg-red`
  * `green`, `bg-green`
  * `yellow`, `bg-yellow`
  * `blue`, `bg-blue`
  * `magenta`, `bg-magenta`
  * `cyan`, `bg-cyan`
  * `white`, `bg-white`

* Available styles (functions) are:
  * `bold`
  * `italic` (not supported on many terminals)
  * `underline`

## License

Copyright (C) 2012 Kevin J. Qiu

Distributed under the Eclipse Public License, the same as Clojure.
