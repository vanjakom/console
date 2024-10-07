(defn load-class-loader [jar-path]
	(java.net.URLClassLoader/newInstance 
		(into-array java.net.URL [(new java.net.URL jar-path)])))

(defn load-class [class-loader class-name]
	(.newInstance (.loadClass class-loader class-name)))

===============

(path-to-url (jar-path-in-maven "org.apache.hadoop" "hadoop-core" "2.3.0-mr1-cdh5.0.3"))

(def clHadoopYarn (load-class-loader (path-to-url (jar-path-in-maven "org.apache.hadoop" "hadoop-core" "2.3.0-mr1-cdh5.0.3"))))

(def fs (.getMethod (load-class clHadoopYarn "org.apache.hadoop.fs.FileSystem") (.getClass org.apache.hadoop.conf.Configuration)))

(def method (com.mungolab.console.ReflectionUtils/getMethod (java.lang.Class/forName "java.lang.String") "valueOf" (into-array java.lang.Class [java.lang.Object])))

(com.mungolab.console.ReflectionUtils/invokeMethod method "" (into-array java.lang.Object [false]))