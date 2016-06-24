package com.simple.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by nik on 23.06.2016.
 */
@Controller
class BaseController {

    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun welcome(model: ModelMap): String {

        model.addAttribute("message", "Welcome")
        model.addAttribute("counter", ++counter)
        logger.debug("[welcome] counter : {}", counter)

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX

    }

    @RequestMapping(value = "/{name}", method = arrayOf(RequestMethod.GET))
    fun welcomeName(@PathVariable name: String, model: ModelMap): String {

        model.addAttribute("message", "Welcome " + name)
        model.addAttribute("counter", ++counter)
        logger.debug("[welcomeName] counter : {}", counter)
        return VIEW_INDEX

    }

    companion object {

        private var counter = 0
        private val VIEW_INDEX = "index"
        private val logger = LoggerFactory.getLogger(BaseController::class.java)
    }

}