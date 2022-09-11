(defproject clojureproject "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :repl-options {:init-ns clojureproject.core})



;;THIS FUNCTION RETURNS THE GREATEST BETWEEN THREE NUMBERS
(defn greatest [x, y, z] (cond
                           (and (> x y) (> x z)) x
                           (and (> y x) (> y z)) y
                           :else z))

;;THIS FUNCTION RETURNS THE SECOND GREATEST BETWEEN THREE NUMBERS
(defn second_greatest [x, y, z] (cond
                                  (or (and (> x y) (< x z)) (and (> x z) (< x y))) x
                                  (or (and (> y x) (< y z)) (and (> y z) (< y x))) y
                                  :else z))

;;THIS FUNCTION RETURNS THE SUM OF THE SQUARE OF THE LARGEST NUMBERS BETWEEN THREE NUMBERS
(defn sumSqrOfTwoGreatest [x, y, z] (+ (sqr (greatest x, y, z)) (sqr (second_greatest x, y, z))))

;;=====================SQUARE ROOT OF A NUMBER BY NEWTON'S METHOD============================

;;THIS FUNCTION RETURNS THE ABSOLUTE VALUE
(defn abs [x] (cond
                (< x 0) (- x)
                (= x 0) 0
                (> x 0) x))

;;THIS FUNCTION RETURNS THE SQUARE OF A NUMBER
(defn sqr [a] (* a a))

;;THIS FUNCTION RETURNS A BOOLEAN THAT CLARIFY WHETHER OR NOT THE GUESS IS GOOD ENOUGH
(defn good-enough? [guess, x] (< (abs (- (sqr guess) x)) 0.0001))

;;THIS FUNCTION IMPROVE THE GUESS BY AVERAGING
(defn improve-guess [guess x] (avg guess (/ x guess)))

;;THIS FUNCTION RETURNS THE SQUARE BY GUESSING AND IMPROVING
(defn sqrt-iter [guess, x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve-guess guess x) x)))

;;THIS FUNCTION RETURNS THE SQUARE, BUT JUST ASKING FOR THE NUMBER
(defn sqrt [x] (sqrt-iter 1 x))

;;===========================================================================================