(ns console.io)

(require 'clojure.data.json)

; (read-lines "/tmp/testfile" (fn [state line] (assoc state "text" line)))
;func should accept state and line and return new state
(defn read-lines [file-path func]
	(with-open [rdr (clojure.java.io/reader file-path)]
         (reduce func {} (line-seq rdr))))

;func should accept state and object and return new state
(defn read-lines [file-path func]
	(with-open [rdr (clojure.java.io/reader file-path)]
         (reduce (fn [state line] (func state (read-json line))) {} (line-seq rdr))))

(defn read-json [line] (clojure.data.json/read-str line))

(defn write-json [object] (clojure.data.json/write-str object))