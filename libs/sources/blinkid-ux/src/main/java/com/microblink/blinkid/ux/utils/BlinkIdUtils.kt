package com.microblink.blinkid.ux.utils

import com.microblink.blinkid.core.result.DocumentRotation
import com.microblink.blinkid.ux.state.PassportPage
import com.microblink.ux.utils.ScreenOrientation

internal const val passportMovePageAnimationDurationMs = 2000

fun getCorrectedDocumentRotation(
    documentRotation: DocumentRotation,
    screenOrientation: ScreenOrientation
): DocumentRotation {
    when (screenOrientation) {
        ScreenOrientation.Portrait -> {
            return when (documentRotation) {
                DocumentRotation.Zero -> DocumentRotation.Clockwise90
                DocumentRotation.Clockwise90 -> DocumentRotation.UpsideDown
                DocumentRotation.CounterClockwise90 -> DocumentRotation.Zero
                DocumentRotation.UpsideDown -> DocumentRotation.CounterClockwise90
                else -> DocumentRotation.Clockwise90
            }
        }

        ScreenOrientation.LandscapeRight -> {
            return documentRotation
        }

        ScreenOrientation.ReversePortrait -> {
            return when (documentRotation) {
                DocumentRotation.Zero -> DocumentRotation.CounterClockwise90
                DocumentRotation.Clockwise90 -> DocumentRotation.Zero
                DocumentRotation.CounterClockwise90 -> DocumentRotation.UpsideDown
                DocumentRotation.UpsideDown -> DocumentRotation.Clockwise90
                else -> DocumentRotation.CounterClockwise90
            }
        }

        ScreenOrientation.LandscapeLeft -> {
            return when (documentRotation) {
                DocumentRotation.Zero -> DocumentRotation.UpsideDown
                DocumentRotation.Clockwise90 -> DocumentRotation.CounterClockwise90
                DocumentRotation.CounterClockwise90 -> DocumentRotation.Clockwise90
                DocumentRotation.UpsideDown -> DocumentRotation.Zero
                else -> DocumentRotation.UpsideDown
            }
        }

        else -> {
            return when (documentRotation) {
                DocumentRotation.Zero -> DocumentRotation.Clockwise90
                DocumentRotation.Clockwise90 -> DocumentRotation.UpsideDown
                DocumentRotation.CounterClockwise90 -> DocumentRotation.Zero
                DocumentRotation.UpsideDown -> DocumentRotation.CounterClockwise90
                else -> DocumentRotation.Clockwise90
            }
        }
    }
}

fun getPassportPageFromRotation(
    documentRotation: DocumentRotation
): PassportPage {
    when (documentRotation) {
        DocumentRotation.Zero -> return PassportPage.Top
        DocumentRotation.Clockwise90 -> return PassportPage.Right
        DocumentRotation.CounterClockwise90 -> return PassportPage.Left
        DocumentRotation.UpsideDown -> return PassportPage.Top
        DocumentRotation.NotAvailable -> return PassportPage.Top
    }
}