(ns console.core)

(use 'clojure.java.io)

(defn load-class-loader [jar-path]
	(def cl (java.net.URLClassLoader/newInstance 
			(into-array java.net.URL [(new java.net.URL jar-path)]))))

(defn load-class [class-loader class-name]
	(.newInstance (.loadClass class-loader class-name)))

(defn jar-path-in-maven [group artifact version] 
	(str "~/.m2/repository/" (clojure.string/replace group #"\." "/") "/" 
		artifact "/" version "/" artifact "-" version ".jar"))

(defn set-engine engine-class)

(defn run-task [mapper-fn reducer-fn input-path output-path] (println "running task"))

(defn read-file [file-path state func] 
	(with-open [rdr (reader "/tmp/test.txt")]
  		(doseq [line (line-seq rdr)]
    		(println line))))


