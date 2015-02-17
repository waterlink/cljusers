(defproject cljusers "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.stuartsierra/component "0.2.2"]
                 [compojure "1.3.1"]
                 [duct "0.1.0"]
                 [environ "1.0.0"]
                 [hanami "0.1.0"]
                 [meta-merge "0.1.1"]
                 [ring "1.3.2"]
                 [ring/ring-defaults "0.1.3"]
                 [ring/ring-json "0.3.1"]
                 [ring-jetty-component "0.2.2"]
                 [duct/hikaricp-component "0.1.0"]
                 [org.postgresql/postgresql "9.3-1102-jdbc4"]]
  :plugins [[lein-environ "1.0.0"]
            [lein-gen "0.2.2"]]
  :generators [[duct/generators "0.1.0"]]
  :duct {:ns-prefix cljusers}
  :main ^:skip-aot cljusers.main
  :uberjar-name "cljusers-standalone.jar"
  :aliases {"gen"   ["generate"]
            "setup" ["do" ["generate" "locals"]]
            "deploy" ["do"
                      ["vcs" "assert-committed"]
                      ["vcs" "push" "heroku" "master"]]}
  :profiles
  {:dev  [:project/dev  :profiles/dev]
   :test [:project/test :profiles/test]
   :uberjar {:aot :all}
   :profiles/dev  {}
   :profiles/test {}
   :project/dev   {:source-paths ["dev"]
                   :repl-options {:init-ns user}
                   :dependencies [[reloaded.repl "0.1.0"]
                                  [org.clojure/tools.namespace "0.2.8"]
                                  [kerodon "0.5.0"]]
                   :env {:port 3000}}
   :project/test  {}})
