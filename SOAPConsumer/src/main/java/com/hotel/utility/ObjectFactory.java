
package com.hotel.utility;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hotel.utility package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BookRoom_QNAME = new QName("http://utility.hotel.com/", "bookRoom");
    private final static QName _BookRoomResponse_QNAME = new QName("http://utility.hotel.com/", "bookRoomResponse");
    private final static QName _BookingsByEmail_QNAME = new QName("http://utility.hotel.com/", "bookingsByEmail");
    private final static QName _BookingsByEmailResponse_QNAME = new QName("http://utility.hotel.com/", "bookingsByEmailResponse");
    private final static QName _CancelReservation_QNAME = new QName("http://utility.hotel.com/", "cancelReservation");
    private final static QName _CancelReservationResponse_QNAME = new QName("http://utility.hotel.com/", "cancelReservationResponse");
    private final static QName _GetRoomFloorAndCapacity_QNAME = new QName("http://utility.hotel.com/", "getRoomFloorAndCapacity");
    private final static QName _GetRoomFloorAndCapacityResponse_QNAME = new QName("http://utility.hotel.com/", "getRoomFloorAndCapacityResponse");
    private final static QName _ListRooms_QNAME = new QName("http://utility.hotel.com/", "listRooms");
    private final static QName _ListRoomsResponse_QNAME = new QName("http://utility.hotel.com/", "listRoomsResponse");
    private final static QName _LoginUser_QNAME = new QName("http://utility.hotel.com/", "loginUser");
    private final static QName _LoginUserResponse_QNAME = new QName("http://utility.hotel.com/", "loginUserResponse");
    private final static QName _RegisterUser_QNAME = new QName("http://utility.hotel.com/", "registerUser");
    private final static QName _RegisterUserResponse_QNAME = new QName("http://utility.hotel.com/", "registerUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hotel.utility
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookRoom }
     * 
     */
    public BookRoom createBookRoom() {
        return new BookRoom();
    }

    /**
     * Create an instance of {@link BookRoomResponse }
     * 
     */
    public BookRoomResponse createBookRoomResponse() {
        return new BookRoomResponse();
    }

    /**
     * Create an instance of {@link BookingsByEmail }
     * 
     */
    public BookingsByEmail createBookingsByEmail() {
        return new BookingsByEmail();
    }

    /**
     * Create an instance of {@link BookingsByEmailResponse }
     * 
     */
    public BookingsByEmailResponse createBookingsByEmailResponse() {
        return new BookingsByEmailResponse();
    }

    /**
     * Create an instance of {@link CancelReservation }
     * 
     */
    public CancelReservation createCancelReservation() {
        return new CancelReservation();
    }

    /**
     * Create an instance of {@link CancelReservationResponse }
     * 
     */
    public CancelReservationResponse createCancelReservationResponse() {
        return new CancelReservationResponse();
    }

    /**
     * Create an instance of {@link GetRoomFloorAndCapacity }
     * 
     */
    public GetRoomFloorAndCapacity createGetRoomFloorAndCapacity() {
        return new GetRoomFloorAndCapacity();
    }

    /**
     * Create an instance of {@link GetRoomFloorAndCapacityResponse }
     * 
     */
    public GetRoomFloorAndCapacityResponse createGetRoomFloorAndCapacityResponse() {
        return new GetRoomFloorAndCapacityResponse();
    }

    /**
     * Create an instance of {@link ListRooms }
     * 
     */
    public ListRooms createListRooms() {
        return new ListRooms();
    }

    /**
     * Create an instance of {@link ListRoomsResponse }
     * 
     */
    public ListRoomsResponse createListRoomsResponse() {
        return new ListRoomsResponse();
    }

    /**
     * Create an instance of {@link LoginUser }
     * 
     */
    public LoginUser createLoginUser() {
        return new LoginUser();
    }

    /**
     * Create an instance of {@link LoginUserResponse }
     * 
     */
    public LoginUserResponse createLoginUserResponse() {
        return new LoginUserResponse();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookRoom }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BookRoom }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "bookRoom")
    public JAXBElement<BookRoom> createBookRoom(BookRoom value) {
        return new JAXBElement<BookRoom>(_BookRoom_QNAME, BookRoom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookRoomResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BookRoomResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "bookRoomResponse")
    public JAXBElement<BookRoomResponse> createBookRoomResponse(BookRoomResponse value) {
        return new JAXBElement<BookRoomResponse>(_BookRoomResponse_QNAME, BookRoomResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingsByEmail }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BookingsByEmail }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "bookingsByEmail")
    public JAXBElement<BookingsByEmail> createBookingsByEmail(BookingsByEmail value) {
        return new JAXBElement<BookingsByEmail>(_BookingsByEmail_QNAME, BookingsByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingsByEmailResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BookingsByEmailResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "bookingsByEmailResponse")
    public JAXBElement<BookingsByEmailResponse> createBookingsByEmailResponse(BookingsByEmailResponse value) {
        return new JAXBElement<BookingsByEmailResponse>(_BookingsByEmailResponse_QNAME, BookingsByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelReservation }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "cancelReservation")
    public JAXBElement<CancelReservation> createCancelReservation(CancelReservation value) {
        return new JAXBElement<CancelReservation>(_CancelReservation_QNAME, CancelReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelReservationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelReservationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "cancelReservationResponse")
    public JAXBElement<CancelReservationResponse> createCancelReservationResponse(CancelReservationResponse value) {
        return new JAXBElement<CancelReservationResponse>(_CancelReservationResponse_QNAME, CancelReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoomFloorAndCapacity }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRoomFloorAndCapacity }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "getRoomFloorAndCapacity")
    public JAXBElement<GetRoomFloorAndCapacity> createGetRoomFloorAndCapacity(GetRoomFloorAndCapacity value) {
        return new JAXBElement<GetRoomFloorAndCapacity>(_GetRoomFloorAndCapacity_QNAME, GetRoomFloorAndCapacity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoomFloorAndCapacityResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRoomFloorAndCapacityResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "getRoomFloorAndCapacityResponse")
    public JAXBElement<GetRoomFloorAndCapacityResponse> createGetRoomFloorAndCapacityResponse(GetRoomFloorAndCapacityResponse value) {
        return new JAXBElement<GetRoomFloorAndCapacityResponse>(_GetRoomFloorAndCapacityResponse_QNAME, GetRoomFloorAndCapacityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListRooms }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListRooms }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "listRooms")
    public JAXBElement<ListRooms> createListRooms(ListRooms value) {
        return new JAXBElement<ListRooms>(_ListRooms_QNAME, ListRooms.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListRoomsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListRoomsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "listRoomsResponse")
    public JAXBElement<ListRoomsResponse> createListRoomsResponse(ListRoomsResponse value) {
        return new JAXBElement<ListRoomsResponse>(_ListRoomsResponse_QNAME, ListRoomsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "loginUser")
    public JAXBElement<LoginUser> createLoginUser(LoginUser value) {
        return new JAXBElement<LoginUser>(_LoginUser_QNAME, LoginUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LoginUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "loginUserResponse")
    public JAXBElement<LoginUserResponse> createLoginUserResponse(LoginUserResponse value) {
        return new JAXBElement<LoginUserResponse>(_LoginUserResponse_QNAME, LoginUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "registerUser")
    public JAXBElement<RegisterUser> createRegisterUser(RegisterUser value) {
        return new JAXBElement<RegisterUser>(_RegisterUser_QNAME, RegisterUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://utility.hotel.com/", name = "registerUserResponse")
    public JAXBElement<RegisterUserResponse> createRegisterUserResponse(RegisterUserResponse value) {
        return new JAXBElement<RegisterUserResponse>(_RegisterUserResponse_QNAME, RegisterUserResponse.class, null, value);
    }

}
