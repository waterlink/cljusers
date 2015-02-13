(ns cljusers.endpoint.status-test
  (:require [com.stuartsierra.component :as component]
            [clojure.test :refer :all]
            [kerodon.core :refer :all]
            [kerodon.test :refer :all]
            [cljusers.endpoint.status :as status]))

(def handler
  (status/status-endpoint {}))

(deftest smoke-test
  (testing "index page exists"
    (-> (session handler)
        (visit "/")
        (has (status? 200) "page exists"))))

(deftest status-ok-test
  (testing "index page returns {status: ok}"
    (-> (session handler)
        (visit "/")
        (has (text? "{\"status\":\"ok\"}") "returns {status: ok}"))))
