<?php

function separateParamsAndBaseURL ($url) {

    $separatedParamsAndBaseURL = explode('?', $url);
    return [
        array_slice(
            explode('/', filter_var(rtrim($separatedParamsAndBaseURL[0], '/'), FILTER_SANITIZE_URL)),
            1
        ),
        isset($separatedParamsAndBaseURL[1]) ? explode('&', $separatedParamsAndBaseURL[1]) : []
    ];
}

function formatParams ($params) {

    $formatedParams = [];
    foreach ($params as $param) {
        $temp = explode('=', $param);
        if (isset($temp[1])) $formatedParams = array_merge($formatedParams, [ $temp[0] => $temp[1] ]);
    }

    return $formatedParams;
}

function getViewCSSPathPrefix ($view) {

    $validator = str_contains(
        $_SERVER['REQUEST_URI'],
        explode('/', $view)[0] . '/'
    );
    return $validator ? '../' : '' ;
}

function sanitizePOST () {

    return array_filter($_POST, fn ($attr) => $attr !== '');
}