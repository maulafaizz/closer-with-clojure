(ns playground)

;; Run function: (fn param1 param2 ...)
(str "Hello World! " "Yeah")

;; Define a variable
(def number 9)

;; Define a function
(defn add-number [x y] (+ x y))
(def subs-number (fn [x y] (- x y)))
(def square #(Math/pow % 2))
(def power #(Math/pow %1 %2))

;; Call a function
(add-number number 1)
(subs-number number 11)
(power number 3)
(square number)

;; Addition with different number type
(+ 1/4 1/9)
(+ 2.0 3)
(+ 2.5 3.0)
(+ 3 2)

;; Type casting number
(float (+ 3/4 2))
(int (+ 3 2/4))

;; List and get element operation
(def mylist '(:a 1))
mylist
(nth mylist 0)

;; Vector and get element operation
(def myvector [5 4 3])
myvector
(get myvector 0)
(nth myvector 0)

;; Map: Use to transform each element of the list 
;; and return a new list with the transformed element within
(defn double-elem [x] (* x 2))
(def vec-ex [1 2 3 4])
vec-ex
(map double-elem vec-ex)
(map #(* % 2) vec-ex)

;; Filter: Use to filter element of collections 
;; that fits certain criteria
(filter #(even? %) vec-ex)

;; Thread last: append the function to the last param of the next function
(apply str (interpose " ~ " ["I" "💖" "Paredit"]))
(->> ["I" "💖" "Paredit"]
     (interpose " ~ ")
     (apply str))

;; Flow control: branching
;; if: Use when you have else condition
(def if-number 4)
if-number
(if (> if-number 0)
  (do (print "It's possitive\n")
      (if (even? if-number)
        (str "It's also even")
        (str "It's an odd number")))
  (str "It's negative"))

;; when: Use when you execute the statement only when it's true
(let [when-number 10] 
  (when (pos-int? when-number) 
    (str "Possitive in when")))

;; cond: Use when you have many if conditions
(let [x -5] (cond (< x 0) (str "Negative") 
                 (= x 0) (str "Zero") 
                 (> x 0) (str "Possitive")))

;; Iteration
;; dotimes: for loop in clojures
(dotimes [i 3]
  (println i))

;; doseq: for each in clojure
(doseq [n '(1 2 3)]
  (println n))

;; recur: must be in tail position -> the outermost function and last expression in if
(defn pow [num power result]
  (if (= power 0) result
        (recur num (dec power) (* num result))))

(pow 2 5 1)









