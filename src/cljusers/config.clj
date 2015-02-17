(ns cljusers.config
  (:require [environ.core :refer [env]]
            [hanami.core :refer [jdbc-uri]]))

(def defaults
  ^:displace {:http {:port 3000}})

(def environ
  {:http {:port (some-> env :port Integer.)}
   :db   {:uri  (some-> env :database-url jdbc-uri)}})
